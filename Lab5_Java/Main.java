/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab5_java;

import freemarker.template.TemplateException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bogdan
 */
public class Main {

    static Catalog catalog = new Catalog("My Books", "d:/media/catalog.ser");

    public static void read() {
        Scanner s = new Scanner(System.in);
        String typeItem = s.next();
        if (typeItem.equals("Song")) {
            System.out.println("Dati anul cantecului:");
            int year = s.nextInt();
            System.out.println("Dati artistul cantecului:");
            String singer = s.next();
            System.out.println("Dati locatia:");
            String location = s.next();
            System.out.println("Dati numele:");
            String name = s.next();
            Song item = new Song(singer, year, location, name);
            catalog.add(item);
        } else if (typeItem.equals("Movie")) {
            System.out.println("Dati nota filmului:");
            int rating = s.nextInt();
            System.out.println("Dati actorul principal al filmului:");
            String actor = s.next();
            System.out.println("Dati locatia:");
            String location = s.next();
            System.out.println("Dati numele:");
            String name = s.next();
            Song item = new Song(actor, rating, location, name);
            catalog.add(item);
        }
    }

    private void testCreateSave() {
        Catalog catalog = new Catalog("My Books", "d:/media/catalog.ser");
        var song = new Song("bestSong", 2010, "d", "Macarena");
        var movie = new Movie("bestmovie", 10, "d", "Macarena");
        catalog.add(song);
        catalog.add(movie);

        try {
            CatalogUtil.save(catalog);
        } catch (IOException ex) {
            System.out.println("Can't save: " + ex);
        }
    }

    private void testLoadView() {
        try {
            Catalog catalog = CatalogUtil.load("d:/java/catalog.ser");
            CatalogUtil.play(catalog.findByName("bestSong"));
        } catch (InvalidCatalogException ex) {
            System.out.print("Can't load: " + ex);
        }
    }

    public static void main(String args[]) {
        //Main app = new Main();
        //app.testCreateSave();
        //app.testLoadView();
        //read();
        var item = new Song("Michael", 1990, "d", "Mcarena");
        catalog.add(item);
        
        try {
            Report report = new Report();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TemplateException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scanner s = new Scanner(System.in);
        String command = s.next();

        switch (command) {
            case "add":
                AddCommand add = new AddCommand();
                add.add();
                break;
            case "list":
                Command list = new ListCommand();
                ((ListCommand)list).list();
                break;
            case "save":
                Command save = new SaveCommand();
                 {
                    try {
                        ((SaveCommand)save).save();
                    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            case "load":
                Command load = new LoadCommand();
                System.out.println("Dati path-ul:");
                 {
                    try {
                        ((LoadCommand)load).load(s.next());
                    } catch (InvalidCatalogException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            case "play":
                Command play = new PlayCommand();
                ((PlayCommand)play).play(item);
                break;
            case "report":
                try {
                    play = new Report();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (TemplateException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            default:
                throw new Invalid(command);
        }
    }

}

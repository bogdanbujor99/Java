/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab5_java;

import static com.mycompany.lab5_java.Main.catalog;
import java.util.Scanner;

/**
 *
 * @author Bogdan
 */
public class AddCommand extends Command{
    public AddCommand(){
        System.out.println("Comanda add");
    }
    public void add(){
        Scanner s =  new Scanner(System.in);
        String typeItem = s.next();
        if(typeItem.equals("Song")){
            System.out.println("Dati anul cantecului:");
            int year = s.nextInt();
            System.out.println("Dati artistul cantecului:");
            String singer = s.next();
            System.out.println("Dati locatia:");
            String location = s.next();
            System.out.println("Dati numele:");
            String name = s.next();
            Song item = new Song(singer,year,location,name);
            catalog.add(item);
        }
        else if(typeItem.equals("Movie")){
            System.out.println("Dati nota filmului:");
            int rating = s.nextInt();
            System.out.println("Dati actorul principal al filmului:");
            String actor = s.next();
            System.out.println("Dati locatia:");
            String location = s.next();
            System.out.println("Dati numele:");
            String name = s.next();
            Song item = new Song(actor,rating,location,name);
            catalog.add(item);
        }
    }
}

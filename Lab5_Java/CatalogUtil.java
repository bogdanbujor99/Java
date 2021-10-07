/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab5_java;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bogdan
 */
public class CatalogUtil {
     public static void save(Catalog catalog)throws IOException {
        try (var oos = new ObjectOutputStream(
        new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }
    
    public static Catalog load(String path)throws InvalidCatalogException{
        try (var oos = new ObjectInputStream(
        new FileInputStream(path))) {
            return (Catalog)oos.readObject();
        } catch (IOException ex) {
            throw new InvalidCatalogException(ex);
        } catch (ClassNotFoundException ex) {
            throw new InvalidCatalogException(ex);
        }
    }
    
    public static void play(Item i){
        Desktop desktop = null;
        try{
        desktop.open(new File(i.getLocation()));
        } catch (IOException ex) {
            System.out.print("Locatia nu este precizata!");
        }
    }
}

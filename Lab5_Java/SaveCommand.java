/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab5_java;

import static com.mycompany.lab5_java.Main.catalog;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author Bogdan
 */
public class SaveCommand extends Command{
    public SaveCommand(){
        System.out.println("Comanda save");
    }
    
    public static void save()throws IOException {
        try (var oos = new ObjectOutputStream(
        new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }
    
}

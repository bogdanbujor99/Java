/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab5_java;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author Bogdan
 */
public class LoadCommand extends Command{

    private Catalog catalog;
    public LoadCommand(){
        System.out.println("Comanda load");
    }
    
    public void load(String path) throws InvalidCatalogException{
        try (var oos = new ObjectInputStream(
        new FileInputStream(path))) {
            catalog = (Catalog)oos.readObject();
        } catch (IOException ex) {
            throw new InvalidCatalogException(ex);
        } catch (ClassNotFoundException ex) {
            throw new InvalidCatalogException(ex);
        }
    }
}

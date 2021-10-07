/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab5_java;

import static com.mycompany.lab5_java.Main.catalog;

/**
 *
 * @author Bogdan
 */
public class ListCommand extends Command{
    public ListCommand(){
        System.out.println("Comanda list");
    }
    public void list(){
        catalog.items.forEach(i->{
            System.out.println(i.getName()+" "+i.getLocation());
        });
    }
}


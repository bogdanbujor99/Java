/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab5_java;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.awt.Desktop;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bogdan
 */
public class Catalog implements Serializable {
    private String name;
    private String path;
    List<Item> items = new ArrayList<>();

    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    
    public void add(Item item) {
        items.add(item);
    }
    
    public void list(){
        items.forEach(i->{
            System.out.println(i.getName()+" "+i.getLocation());
        });
    }
    
    public Item findByName(String name) {
        return items.stream()
        .filter(d -> d.getName().equals(name)).findFirst().orElse(null);
    }
    
}
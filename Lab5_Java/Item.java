/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab5_java;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Bogdan
 */
public abstract class Item implements Serializable{
    protected String name;
    protected String location;
    private Map<String, Object> tags = new HashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Map<String, Object> getTags() {
        return tags;
    }

    public void setTags(Map<String, Object> tags) {
        this.tags = tags;
    }
    
    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }

}

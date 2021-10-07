/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab5_java;

/**
 *
 * @author Bogdan
 */
public class Movie extends Item{
    private String actor;
    private int rating;

    public Movie(String actor, int rating, String location,String name) {
        this.actor = actor;
        this.rating = rating;
        this.location = location;
        this.name = name;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}

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
public class Song extends Item {

    private int year;
    private String singer;

    public Song(String singer,int year, String location, String name) {
        this.singer = singer;
        this.year=year;
        this.location=location;
        this.name=name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
    
    
}

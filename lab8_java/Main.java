/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab8_java;

import dao.Actors;
import dao.Genres;
import dao.Movies;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Bogdan
 */
public class Main {
    public static void main(String []args) throws InterruptedException{
        Connection con = Singleton.getConnection();
        //Movies.addMovie("test2", Date.valueOf(LocalDate.now()) , 0, 0);
        //Genres.addGenres("action");
        //System.out.println(Genres.returnGenres(1));
        //System.out.println(Movies.returnMovie(1));
        Actors.addActors("Silvester", "test2");
        sleep(10000);
    }
}
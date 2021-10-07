/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mycompany.lab8_java.Singleton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDate;
import java.sql.Date;
import java.sql.ResultSet;

/**
 *
 * @author Bogdan
 */
public class Movies {
    private Movies(){}
    
    public static void addMovie( String title, Date release_date, int duration, int score){
        Connection conn = Singleton.getConnection();
        try {
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO movie (title, release_date, duration, score) VALUES ('" + title + " , " + release_date + " , "+ duration +", "+ score +" );"; 
            stmt.executeUpdate(sql);
            stmt.close();
            conn.commit();
        }
        catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
        }
    }
    
    public static String returnMovie(int id){
        Connection conn = Singleton.getConnection();
        try {
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT title FROM movie WHERE id= '" + id + "' ;" );
            String name = rs.getString("title");
            rs.close();
            stmt.close();
            return name;
        }
        catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
        }
     return null;   
    }
}

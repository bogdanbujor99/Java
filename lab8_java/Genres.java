/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mycompany.lab8_java.Singleton;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

/**
 *
 * @author Bogdan
 */
public class Genres {
    private Genres(){}
    
    public static void addGenres(String genresName){
        Connection conn = Singleton.getConnection();
        try {
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO genres (name) VALUES ('" + genresName + "');"; 
            stmt.executeUpdate(sql);
            stmt.close();
            conn.commit();
        }
        catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
        }
    }
    
    public static String returnGenres(int id){
        Connection conn = Singleton.getConnection();
        try {
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT name FROM genres WHERE id= '" + id + "' ;" );
            String name = rs.getString("name");
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

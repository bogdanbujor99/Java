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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bogdan
 */
public class Actors {
    
    private static List<String> listMovies;
    
    private Actors(){}
    
    public static void addActors(String actorName, String title){
        Connection conn = Singleton.getConnection();
        try {
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO actors (name, title_movie) VALUES ('" + actorName + "," + title + "');" ; 
            stmt.executeUpdate(sql);
            stmt.close();
            conn.commit();
        }
        catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
        }
    }
    
    public static List<String> returnActor(String nameActor){
        Connection conn = Singleton.getConnection();
        try {
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT title_movie FROM actors WHERE name= '" + nameActor + "' ;" );
            listMovies = new ArrayList<>();
            while( rs.next() ){
                listMovies.add(rs.getString("title_movie"));
            }
            rs.close();
            stmt.close();
            return listMovies;
        }
        catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
        }
     return null;   
    }
}

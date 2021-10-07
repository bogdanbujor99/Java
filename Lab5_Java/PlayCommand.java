/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab5_java;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Bogdan
 */
public class PlayCommand extends Command{
    public PlayCommand(){
        System.out.println("Comanda play");
    }
    public void play(Item i){
        Desktop desktop = null;
        try{
        desktop.open(new File(i.getLocation()));
        } catch (IOException ex) {
            System.out.print("Locatia nu este precizata!");
        }
    }
}

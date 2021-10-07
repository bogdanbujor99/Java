/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab7_java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Bogdan
 */
public class Player implements Runnable {
    private String name;
    private Game game;
    private boolean running;
    private List<Token> list = new ArrayList<>();
    
    Player(String name) {
        this.name = name;
    }

    /**
     * @param game the game to set
     */
    public void setGame(Game game) {
        this.game = game;
    }
    
    @Override
    public void run(){
        running = true;
        while(running){
            System.out.println("aici2");
            synchronized(this){
                int i,j;
                Random random =  new Random();
                i = random.nextInt(game.getN());
                j = random.nextInt(game.getN());
                while(!game.getBoard().ckeckExistToken(i, j) && game.getBoard().ckeckExistTokens()){
                    System.out.println("aici3");
                    i = random.nextInt(game.getN());
                    j = random.nextInt(game.getN());
                }
                game.getBoard().extractToken(i, j);
            }
            running = game.getBoard().ckeckExistTokens();
        }
    }
}

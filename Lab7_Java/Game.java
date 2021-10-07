/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab7_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Bogdan
 */
public class Game {
    private int n;
    private Board board;
    private List<Player> players= new ArrayList<>();

    /**
     * @return the n
     */
    public int getN() {
        return n;
    }

    /**
     * @return the board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * @return the players
     */
    public List<Player> getPlayers() {
        return players;
    }
    
    public void start(){
        for(Player player: players){
                new Thread(player).start();
        }
    }
    
    private void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }
    
    public static void main(String[] args){
        Game game = new Game();
        game.n = 5;
        game.board = new Board(game.n);
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.start();
    }

}

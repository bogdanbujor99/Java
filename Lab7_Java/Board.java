/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab7_java;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Bogdan
 */
public class Board {
    private Token[][] board;
    private boolean[][] tokenValid; 
    int n;
    
    Board(int n){
        this.n = n;
        board = new Token[n][n];
        tokenValid = new boolean[n][n];
        for(int i=0;i<=n-1;i++)
            for(int j=0;j<=n-1;j++){
                board[i][j] = new Token(5);
                tokenValid[i][j] = true;
            }
    }
    
    boolean ckeckExistTokens(){
        boolean ok = false;
        for(int i=0;i<=n-1;i++)
            for(int j=0;j<=n-1;j++)
                if(tokenValid[i][j]) ok = true;
        System.out.println("aici1");
        return ok;
    }
    
    boolean ckeckExistToken(int i, int j){
        return tokenValid[i][j];
    }
    
    public void extractToken(int i,int j){
        tokenValid[i][j] = false;
    }
    
}

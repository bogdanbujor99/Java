/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab7_java;

import java.util.Random;

/**
 *
 * @author Bogdan
 */
public class Token {
    private int i,j,value;
    Token(int n){
        Random random = new Random();
        i = random.nextInt(n)+1;
        j = random.nextInt(n)+1;
        while(j==i){
            j = random.nextInt(n)+1;
        }
        value = random.nextInt(50)+1;
    }
}

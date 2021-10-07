/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab3;

/**
 *
 * @author Bogdan
 */
public class Hotel extends Location implements Classifiable {

    private double rank;

    public Hotel() {
        setName("v" + this.i);
        this.i++;
    }

    /**
     * @return the rank
     */
    public double getRank() {
        return rank;
    }

    /**
     * @param rank the rank to set
     */
    public void setRank(double rank) {
        this.rank = rank;
    }
}

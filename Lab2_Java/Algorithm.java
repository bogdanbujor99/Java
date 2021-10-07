/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab2_java;

/**
 *
 * @author Bogdan
 */
public abstract class Algorithm {

    protected Source[] sources;
    protected Destination[] destinations;
    protected int supply[];
    protected int demand[];
    protected int cost[][];
    int n, m;

    abstract public Solution solve();
    //este o functie abstracta care rezolva prb. si va fi definita in clasele ce mostenesc Algorithm 

    public boolean existSupply() { //cauta daca mai exista supply
        for (int i = 0; i < supply.length; i++) {
            if (supply[i] != 0) {
                return true;
            }
        }
        return false;
    }

    public boolean existDemand() { //cauta daca mai exista demand
        for (int i = 0; i < demand.length; i++) {
            if (demand[i] != 0) {
                return true;
            }
        }
        return false;
    }

    public int[] min() { //cauata costul minim din toata matricea cost
        int min = cost[0][0];
        int l = 0;
        int c = 0;
        for (int i = 0; i <= n - 1; i++) {
            for (int j = 0; j <= m - 1; j++) {
                if (min > cost[i][j]) {
                    min = cost[i][j];
                    l = i;
                    c = j;
                }
            }
        }
        cost[l][c] = Integer.MAX_VALUE; //cel mai mic cost primeste o valoare maxima pentru a nu mai fi folosita
        int[] minCoordonate = new int[3];
        minCoordonate[0] = l;
        minCoordonate[1] = c;
        minCoordonate[2] = min;
        return minCoordonate;
    }
}

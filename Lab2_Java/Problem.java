/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab2_java;

import java.util.*;

/**
 *
 * @author Bogdan
 */
public class Problem {

    private Source[] sources;
    private Destination[] destinations;
    private int supply[];
    private int demand[];
    private int cost[][];

    /**
     * @param sources the sources to set
     */
    public void setSources(Source[] sources) {
        int k = 0;
        for (int i = 0; i <= sources.length - 1; i++) {
            int nr = 0;
            for (int j = 0; j <= i - 1; j++) {
                if (sources[i].equals(sources[j])) {
                    nr++;
                }
            }
            if (nr == 0) {
                k++;
            }
        }
        this.sources = new Source[k];
        k = 0;
        for (int i = 0; i <= sources.length - 1; i++) {
            int nr = 0;
            for (int j = 0; j <= i - 1; j++) {
                if (sources[i].equals(sources[j])) {
                    nr++;
                    System.out.println(sources[i] + " a fost adaugat deja!");
                    //nu o sa ne lase sa adaugam de 2 ori o sursa si va returna acest mesaj
                }
            }
            if (nr == 0) { //daca nu mai este adaugata sursa o adaugam
                this.sources[k] = sources[i];
                k++;
            }
        }
    }

    /**
     * @param destinations the destinations to set
     */
    public void setDestinations(Destination[] destinations) {
        int k = 0;
        for (int i = 0; i <= destinations.length - 1; i++) {
            int nr = 0;
            for (int j = 0; j <= i - 1; j++) {
                if (destinations[i].equals(destinations[j])) {
                    nr++;
                }
            }
            if (nr == 0) {
                k++;
            }
        }
        this.destinations = new Destination[k];
        k = 0;
        for (int i = 0; i <= destinations.length - 1; i++) {
            int nr = 0;
            for (int j = 0; j <= i - 1; j++) {
                if (destinations[i].equals(destinations[j])) {
                    nr++;
                    System.out.println(destinations[i] + " a fost adaugat deja!");
                    //nu o sa ne lase sa adaugam de 2 ori o destinatie si va returna acest mesaj
                }
            }
            if (nr == 0) { //daca nu mai este adaugata destinatia o adaugam
                this.destinations[k] = destinations[i];
                k++;
            }
        }
    }

    /**
     * @param supply the supply to set
     */
    public void setSupply(int[] supply) {
        this.supply = supply;
    }

    /**
     * @param demand the demand to set
     */
    public void setDemand(int[] demand) {
        this.demand = demand;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(int[][] cost) {
        this.cost = cost;
    }

    /**
     * @return the sources
     */
    public Source[] getSources() {
        return sources;
    }

    /**
     * @return the destinations
     */
    public Destination[] getDestinations() {
        return destinations;
    }

    /**
     * @return the supply
     */
    public int[] getSupply() {
        return supply;
    }

    /**
     * @return the demand
     */
    public int[] getDemand() {
        return demand;
    }

    /**
     * @return the cost
     */
    public int[][] getCost() {
        return cost;
    }

    @Override
    public String toString() { //returneaza toate datele problemei intr-un string
        String prb = new String("   ");
        for (int i = 1; i <= demand.length; i++) {
            prb = prb + "D" + i + " ";
        }
        prb = prb + " S" + "\n";
        for (int i = 0; i <= supply.length - 1; i++) {
            prb = prb + "S" + (i + 1) + "  ";
            for (int j = 0; j <= demand.length - 1; j++) {
                prb = prb + cost[i][j] + "  ";
            }
            prb = prb + supply[i] + "\n";
        }
        prb = prb + "D  ";
        for (int i = 1; i <= demand.length; i++) {
            prb = prb + demand[i - 1] + "  ";
        }
        return prb;
    }

    public void randomProblem() { // generarea unei probleme random
        Random random = new Random();
        int k = random.nextInt(91) + 10; //generarea supply-ului si demand-ului total
        int k1 = k;
        int n = 0, m = 0;
        int[] s = new int[k];
        while (k1 != 0) { //generarea surcelor si supply-ului propriu
            s[n] = random.nextInt(k1);
            if (s[n] == 0) {
                s[n]++;
            }
            k1 = k1 - s[n];
            n++;
        }
        n--;
        this.supply = new int[n];
        for (int i = 0; i <= n - 1; i++) {
            this.supply[i] = s[i];
        }
        k1 = k;
        int[] d = new int[k];
        while (k1 != 0) { //generarea destinatiilor si demand-ului propriu
            d[m] = random.nextInt(k1);
            if (d[m] == 0) {
                d[m]++;
            }
            k1 = k1 - d[m];
            m++;
        }
        m--;
        this.demand = new int[m];
        for (int i = 0; i <= m - 1; i++) {
            this.demand[i] = d[i];
        }
        this.sources = new Source[n]; //setarea numelor surcelor 
        for (int i = 0; i <= n - 1; i++) {
            if (i % 2 == 0) {
                this.sources[i] = new Factory("S" + i + 1);
            } else {
                this.sources[i] = new Warehouse("S" + i + 1);
            }
        }
        this.destinations = new Destination[m]; //setarea numelor destinatiilor
        for (int i = 0; i <= m - 1; i++) {
            if (i % 2 == 0) {
                this.destinations[i] = new Destination("D" + i + 1);
            } else {
                this.destinations[i] = new Destination("D" + i + 1);
            }
        }
        this.cost = new int[n][m]; //setarea costului
        for (int i = 0; i <= n - 1; i++) {
            for (int j = 0; j <= m - 1; j++) {
                this.cost[i][j] = random.nextInt(9) + 1;
            }
        }
    }

}

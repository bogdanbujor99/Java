/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab2_java;

import java.util.Arrays;

/**
 *
 * @author Bogdan
 */
public class Solution {

    private int[][] x;
    private int[][] cost;
    int n;
    int m;

    Solution() {
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(int[][] cost) {
        this.cost = new int[n][m];
        for (int i = 0; i <= n - 1; i++) {
            for (int j = 0; j <= m - 1; j++) {
                this.cost[i][j] = cost[i][j];
            }
        }
    }

    /**
     * @param x the x to set
     */
    public void setX(int n, int m) {
        this.x = new int[n][m];
        this.n = n;
        this.m = m;
        for (int i = 0; i <= n - 1; i++) {
            for (int j = 0; j <= m - 1; j++) {
                x[i][j] = 0;
            }
        }
    }

    public void units(int i, int j, int unit) {
        x[i][j] = unit;
    }

    public int computeCost() {
        int costS = 0;
        for (int i = 0; i <= n - 1; i++) {
            for (int j = 0; j <= m - 1; j++) {
                costS += x[i][j] * cost[i][j];
            }
        }
        return costS;
    }

    @Override
    public String toString() { //returneaza intr-un string solutia problemei data
        String solution = new String();
        for (int i = 0; i <= n - 1; i++) {
            for (int j = 0; j <= m - 1; j++) {
                if (x[i][j] != 0) {
                    solution = solution + "S" + (i + 1) + "->" + "D" + (j + 1) + ": " + x[i][j] + " units * cost" + cost[i][j] + "=" + x[i][j] * cost[i][j] + "\n";
                }
            }
        }
        solution = solution + "Totat cost: " + computeCost();
        return solution;
    }

}

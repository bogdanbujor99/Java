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
public class VogelAlgorithm extends Algorithm {

    private int[] rowDiff; //reprezinta diferenta absoluta pe linie dintre cele mai mici 2 elemente 
    private int[] columnDiff; //reprezinta diferenta absoluta pe coloana dintre cele mai mici 2 elemente 

    public VogelAlgorithm(Problem pb) { //setarea datelor problemei
        sources = pb.getSources();
        destinations = pb.getDestinations();
        supply = pb.getSupply();
        demand = pb.getDemand();
        cost = pb.getCost();
        n = sources.length;
        m = demand.length;
        rowDiff = new int[n];
        columnDiff = new int[m];
    }

    public void rowDifference() { //diferenta absoluta pentru fiecare linie a celor mai mici 2 elemente
        int min1, min2;
        for (int i = 0; i <= n - 1; i++) {
            min1 = Integer.MAX_VALUE;
            min2 = Integer.MAX_VALUE;
            for (int j = 0; j <= m - 1; j++) {
                if (min1 > cost[i][j]) {
                    min2 = min1;
                    min1 = cost[i][j];
                } else if (min2 > cost[i][j]) {
                    min2 = cost[i][j];
                }
            }
            if (min1 == Integer.MAX_VALUE) {
                rowDiff[i] = Integer.MIN_VALUE;
            } else if (min2 == Integer.MAX_VALUE) {
                rowDiff[i] = -1;
            } else if (supply[i] == 0) {
                rowDiff[i] = Integer.MIN_VALUE;
            } else {
                rowDiff[i] = Math.abs(min1 - min2);
            }
        }
    }

    public void columnDifference() { //diferenta absoluta pentru fiecare coloana a celor mai mici 2 elemente
        int min1, min2;
        for (int j = 0; j <= m - 1; j++) {
            min1 = Integer.MAX_VALUE;
            min2 = Integer.MAX_VALUE;
            for (int i = 0; i <= n - 1; i++) {
                if (min1 > cost[i][j]) {
                    min2 = min1;
                    min1 = cost[i][j];
                } else if (min2 > cost[i][j]) {
                    min2 = cost[i][j];
                }
            }
            if (min1 == Integer.MAX_VALUE) {
                columnDiff[j] = Integer.MIN_VALUE;
            } else if (min2 == Integer.MAX_VALUE) {
                columnDiff[j] = -1;
            } else if (demand[j] == 0) {
                columnDiff[j] = Integer.MIN_VALUE;
            } else {
                columnDiff[j] = Math.abs(min1 - min2);
            }
        }
    }

    public int minRow(int row) { //cea mai mica valoare de pe linie
        int min = Integer.MAX_VALUE;
        int column = 0;
        for (int j = 0; j <= m - 1; j++) {
            if (min > cost[row][j] && demand[j] != 0) {
                min = cost[row][j];
                column = j;
            }
        }
        return column;
    }

    public int minColumn(int column) { //cea mai mica valoare de pe coloana
        int min = Integer.MAX_VALUE;
        int row = 0;
        for (int i = 0; i <= n - 1; i++) {
            if (min > cost[i][column] && supply[i] != 0) {
                min = cost[i][column];
                row = i;
            }
        }
        return row;
    }

    public void rowCost(int row) { //update la linia cu Si=0 pentru a nu mai fi folosita
        for (int j = 0; j <= m - 1; j++) {
            cost[row][j] = Integer.MAX_VALUE;
        }
    }

    public void columnCost(int column) { //update la coloana cu Dj=0 pentru a nu mai fi folosita
        for (int i = 0; i <= n - 1; i++) {
            cost[i][column] = Integer.MAX_VALUE;
        }
    }

    public Solution solve() {
        Solution sol = new Solution();
        sol.setX(n, m);
        sol.setCost(cost);
        while (existDemand() && existSupply()) { //verific daca mai exista supply sau demand
            columnDifference(); //diferenta absoluta pentru fiecare coloana a celor mai mici 2 elemente
            rowDifference(); //diferenta absoluta pentru fiecare linie a celor mai mici 2 elemente
            int max = Integer.MIN_VALUE;
            int row = 0;
            int column = 0;
            char where = 'r';
            /**
             * La primul for caut valoarea maxima a diferentei celor mai mici 2 elemente de pe fiecare linie 
             * La al doilea for caut valoarea maxima a diferentei celor mai mici 2 elemente de pe fiecare coloana
             */
            for (int i = 0; i <= n - 1; i++) {
                if (max < rowDiff[i]) {
                    max = rowDiff[i];
                    row = i;
                }
            }
            for (int i = 0; i <= m - 1; i++) {
                if (max < columnDiff[i]) {
                    max = columnDiff[i];
                    where = 'c';
                    column = i;
                }
            }
            /**
             * La primul if daca cea mai mare diferenta este pe linie, caut pe acea linie elementul cel mai mic
             * La al doilea if daca cea mai mare diferenta este pe coloana, caut pe acea coloana elementul cel mai mic
             */
            if (where == 'r') {
                column = minRow(row);
            } else {
                row = minColumn(column); 
            }
            if (supply[row] < demand[column]) {
                sol.units(row, column, supply[row]); //cate unitati furnizeaza S row lui D column
                demand[column] = demand[column] - supply[row]; //update la demand
                supply[row] = 0; //update la supply
                rowCost(row); //update la linie, pentru a nu mai fi folosita mai tarziu aceasta linie cu supply=0
                if (demand[column] == 0) {
                    columnCost(column); //update la coloana, pentru a nu mai fi folosita mai tarziu aceasta coloana cu demand=0
                }
            } else if (supply[row] > demand[column]) {
                sol.units(row, column, demand[column]);
                supply[row] = supply[row] - demand[column];
                demand[column] = 0;
                columnCost(column);
                if (supply[row] == 0) {
                    rowCost(row);
                }
            } else {
                sol.units(row, column, supply[row]);
                supply[row] = 0;
                demand[column] = 0;
                rowCost(row);
                columnCost(column);
            }
        }
        return sol;
    }
}

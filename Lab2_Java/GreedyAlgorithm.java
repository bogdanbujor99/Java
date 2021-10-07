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
public class GreedyAlgorithm extends Algorithm {

    GreedyAlgorithm(Problem pb) { //setarea datelor problemei
        sources = pb.getSources();
        destinations = pb.getDestinations();
        supply = pb.getSupply();
        demand = pb.getDemand();
        cost = pb.getCost();
        n = sources.length;
        m = demand.length;
    }

    public Solution solve() {
        Solution sol = new Solution();
        sol.setX(n, m);
        sol.setCost(cost);
        while (existSupply()) { //caut daca mai exista supply de oferit
            int[] minCoordoante = min(); //caut minimul din matricea cost
            int row = minCoordoante[0]; //linia din cost
            int column = minCoordoante[1]; //coloana din cost
            if (supply[row] < demand[column] && supply[row] != 0) {
                sol.units(row, column, supply[row]); //cate unitati furnizeaza S row lui D column
                demand[column] = demand[column] - supply[row]; //update la D column
                supply[row] = 0; //update la S row
            } else if (supply[row] > demand[column] && demand[column] != 0) {
                sol.units(row, column, demand[column]);
                supply[row] = supply[row] - demand[column];
                demand[column] = 0;
            } else if (demand[column] != 0 && supply[row] != 0) {
                sol.units(row, column, demand[column]);
                demand[column] = 0;
                supply[row] = 0;
            }
        }
        return sol;
    }
}

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
public class Main {

    public static void main(String[] arg) {

        Problem pb = new Problem();

        Source[] sources = new Source[4];
        sources[0] = new Factory("S1");
        sources[1] = new Factory("S1");
        sources[2] = new Factory("S2");
        sources[3] = new Warehouse("S3");
        pb.setSources(sources);

        Destination[] destinations = new Destination[4];
        destinations[0] = new Destination("D1");
        destinations[1] = new Destination("D2");
        destinations[2] = new Destination("D2");
        destinations[3] = new Destination("D3");
        pb.setDestinations(destinations);

        int[] supply = new int[3];
        int[] demand = new int[3];
        supply[0] = 10;
        supply[1] = 35;
        supply[2] = 25;
        demand[0] = 20;
        demand[1] = 25;
        demand[2] = 25;
        pb.setSupply(supply);
        pb.setDemand(demand);

        int[][] cost = new int[3][3];
        cost[0][0] = 2;
        cost[0][1] = 3;
        cost[0][2] = 1;
        cost[1][0] = 5;
        cost[2][0] = 5;
        cost[1][1] = 4;
        cost[1][2] = 8;
        cost[2][2] = 8;
        cost[2][1] = 6;

        pb.setCost(cost);

        System.out.println(pb);

        Algorithm greedy = new GreedyAlgorithm(pb);
        Solution solGreedy = greedy.solve();
        System.out.println(solGreedy);

        Problem prb = new Problem();
        prb.randomProblem();
        System.out.println(prb);

        Algorithm vogel = new VogelAlgorithm(prb);
        Solution solVogel = vogel.solve();
        System.out.println(solVogel);
    }
}

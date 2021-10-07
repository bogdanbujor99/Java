/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bogdan
 */
public class TravelPlan {

    City city;
    List<Location> pref = new ArrayList<Location>();

    TravelPlan() {
    }

    TravelPlan(City c) {
        this.city = c;
    }

    TravelPlan(City c, List<Location> l) {
        this.city = c;
        List<Location> nodes = city.getNodes();
        for (Location i : l) {
            if (nodes.contains(i)) { //adaug noul nod la preferinte doar daca acesta se afla in orasul respectiv
                int k = nodes.indexOf(i);
                pref.add(nodes.get(k)); //il adaug cu numele pe care si in city
            }
        }
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Location> getPref() {
        return pref;
    }

    public void setPref(List<Location> pref) {
        List<Location> nodes = city.getNodes();
        for (Location i : nodes) {
            if (nodes.contains(i)) { //adaug noul nod la preferinte doar daca acesta se afla in orasul respectiv
                int k = nodes.indexOf(i);
                pref.add(nodes.get(k)); //il adaug cu numele pe care si in city
            }
        }
    }

    public void dijkstra(int start, int finish) {
        int[][] matrix = city.mapCity(); //graful pentru harta orasului intre obiective
        int n = matrix.length;
        int[] distance = new int[n]; //aici vom calcula distanta cea mai mica de la start la toate nodurile
        boolean[] included = new boolean[n]; //pentru a conturiza nodurile care au fost incluse intr-un shortest path

        for (int i = 0; i <= n - 1; i++) {
            distance[i] = Integer.MAX_VALUE; //initial toate au infinit
            included[i] = false;  //initial toate neincluse
        }
        distance[start] = 0;

        for (int i = 0; i <= n - 2; i++) {
            int min = minDistance(distance, included, n); //pozitia unde se afla nodul cu cea mai mica distanta
            included[min] = true; // il trecem ca inclus
            for (int j = 0; j <= n - 1; j++) //aici voi schimba valoarea distantei a varfurilor adiacente
            {
                if (!included[j] && matrix[min][j] != 0
                        && distance[min] != Integer.MAX_VALUE && distance[min] + matrix[min][j] < distance[j]) //vom schimba valoarea doar daca nu a fost deja inclus nodul sau daca valoarea ar fi mai mica decat valoarea curenta 
                {
                    distance[j] = distance[min] + matrix[min][j];
                }
            }
        }
        List<Location> nodes = city.getNodes();
        System.out.println("Costul cel mai mic intre " + nodes.get(start).getName() + " si " + nodes.get(finish).getName() + " " + distance[finish]);
    }

    public void shortestPath() {
        for (int i = 0; i <= pref.size() - 2; i++) {
            int start = Integer.parseInt(Character.toString(pref.get(i).getName().charAt(1))) - 1; //nodul de unde plecam
            int finish = Integer.parseInt(Character.toString(pref.get(i + 1).getName().charAt(1))) - 1; //nodul unde vrem sa ajungem
            dijkstra(start, finish);
        }
    }

    int minDistance(int distance[], boolean included[], int n) //in aceasta functie caut nodul cu distanta cea mai mica care nu este inclus in graful meu
    {
        int min = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i <= n - 1; i++) {
            if (included[i] == false && distance[i] <= min) {
                min = distance[i];
                index = i;
            }
        }

        return index; // returnez pozitia unde se afla
    }

}

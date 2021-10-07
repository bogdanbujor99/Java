/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab3;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

/**
 *
 * @author Bogdan
 */
public class City {

    private List<Location> nodes = new ArrayList<>();

    public City() {
    }

    /**
     * @return the nodes
     */
    public List<Location> getNodes() {
        return nodes;
    }

    /**
     * @param nodes the nodes to set
     */
    public void setNodes(List<Location> nodes) {
        this.nodes = nodes;
    }

    public void addLocation(Location node) {
        nodes.add(node);
        Collections.sort(nodes, Location::compareTo);
    }

    public void visitablebNotPayable() {
        List<Location> l = new ArrayList<>();
        for (Location i : this.nodes) {
            if (!(i instanceof Classifiable || i instanceof Payable)) {
                l.add(i); //adaug la l acele locatii care sunt visitabile, dar nu si payable 
            }
        }
        for (int i = 0; i <= l.size() - 1; i++) {
            for (int j = 0; j <= i - 1; j++) {
                Visitable v1 = (Visitable) l.get(i);
                Visitable v2 = (Visitable) l.get(j);
                if (v1.getOpeningTime() != null && v2.getOpeningTime() != null) {
                    int ok = v1.getOpeningTime().compareTo(v2.getOpeningTime()); //compar orele de deschidere
                    if (ok == -1) {
                        Collections.swap(l, i, j); //daca trebuie, interschimb locaatiile
                    }
                }
            }
        }
        for (Location i : l) {
            System.out.println(i.getName());
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Location i : nodes) {
            s.append(i.getName() + " ");
        }
        return s.toString();
    }

    public int[][] mapCity() { //harta orasului intr-o matrice
        int[][] mapCityCost = new int[nodes.size()][nodes.size()];
        int k = 0;
        for (Location i : nodes) {
            Map<Location, Integer> cost = i.getCost();
            for (Location j : cost.keySet()) {
                String s = j.getName();
                int m = Integer.parseInt(Character.toString(s.charAt(1)));
                m--;
                mapCityCost[k][m] = cost.get(j);
            }
            k++;
        }
        return mapCityCost;
    }
}

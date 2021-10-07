/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab3;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Bogdan
 */
public abstract class Location implements Comparable<Location> {

    private String name;
    private Map<Location, Integer> cost = new HashMap<>();
    protected static int i = 1;

    public Location() {
    }

    public Location(String name) {
        this.name = name;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(Map<Location, Integer> cost) {
        this.cost = cost;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the cost
     */
    public Map<Location, Integer> getCost() {
        return cost;
    }

    public void setCost(Location node, int value) {
        cost.put(node, value);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Location i : cost.keySet()) {
            s.append(this.name + "->" + i.name + " " + cost.get(i) + "\n");
        }
        return s.toString();
    }

    @Override
    public int compareTo(Location o) {
        if (o.name == null) {
            return 0;
        } else if (this.name == null) {
            return 0;
        } else {
            return this.name.compareTo(o.name);
        }
    }
}

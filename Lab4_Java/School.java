/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab4_java;

/**
 *
 * @author Bogdan
 */
public class School {

    private int capacity;
    private String nameSchool;
    private double minGrade;

    public School(int capacity, String nameSchool) {
        this.capacity = capacity;
        this.nameSchool = nameSchool;
    }

    public School(String nameSchool) {
        this.nameSchool = nameSchool;
    }

    /**
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @param capacity the capacity to set
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * @return the nameSchool
     */
    public String getNameSchool() {
        return nameSchool;
    }

    /**
     * @param nameSchool the nameSchool to set
     */
    public void setNameSchool(String nameSchool) {
        this.nameSchool = nameSchool;
    }

    /**
     * @return the minGrade
     */
    public double getMinGrade() {
        return minGrade;
    }

    /**
     * @param minGrade the minGrade to set
     */
    public void setMinGrade(double minGrade) {
        this.minGrade = minGrade;
    }
}

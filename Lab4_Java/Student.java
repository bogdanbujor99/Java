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
public class Student {

    private double grade;
    private String nameStudent;

    public Student(double grade, String nameStudent) {
        this.grade = grade;
        this.nameStudent = nameStudent;
    }

    public Student(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    /**
     * @return the rank
     */
    public double getGrade() {
        return grade;
    }

    /**
     * @param rank the rank to set
     */
    public void setGrade(double grade) {
        this.grade = grade;
    }

    /**
     * @return the nameStudent
     */
    public String getNameStudent() {
        return nameStudent;
    }

    /**
     * @param nameStudent the nameStudent to set
     */
    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

}

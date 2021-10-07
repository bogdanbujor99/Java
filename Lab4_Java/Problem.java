/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab4_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Bogdan
 */
public class Problem {

    private Map<School, List<Student>> stdPrefMapSchool = new HashMap<>();
    private Map<Student, List<School>> stdPrefMapStudent = new HashMap<>();

    public Problem() {
    }

    /**
     * @return the stdPrefMapSchool
     */
    public Map<School, List<Student>> getStdPrefMapSchool() {
        return stdPrefMapSchool;
    }

    /**
     * @param stdPrefMapSchool the stdPrefMapSchool to set
     */
    public void setStdPrefMapSchool(Map<School, List<Student>> stdPrefMapSchool) {
        this.stdPrefMapSchool = stdPrefMapSchool;
    }

    /**
     * @return the stdPrefMapStudent
     */
    public Map<Student, List<School>> getStdPrefMapStudent() {
        return stdPrefMapStudent;
    }

    /**
     * @param stdPrefMapStudent the stdPrefMapStudent to set
     */
    public void setStdPrefMapStudent(Map<Student, List<School>> stdPrefMapStudent) {
        this.stdPrefMapStudent = stdPrefMapStudent;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        stdPrefMapStudent.entrySet().forEach(i -> {
            s.append(i.getKey().getNameStudent());
            s.append(": (");
            List<School> prefListSchool = i.getValue();
            prefListSchool.forEach(j -> {
                s.append(j.getNameSchool());
                s.append(" ");
            });
            s.append(")\n");
        });
        s.append("\n");
        stdPrefMapSchool.entrySet().forEach(i -> {
            s.append(i.getKey().getNameSchool());
            s.append(": (");
            List<Student> prefListStudent = i.getValue();
            prefListStudent.forEach(j -> {
                s.append(j.getNameStudent());
                s.append(" ");
            });
            s.append(")\n");
        });
        return s.toString();
    }

}

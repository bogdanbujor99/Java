/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab4_java;

import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.*;

/**
 *
 * @author Bogdan
 */
public class Main {

    static List<Student> studentList = new LinkedList<>(); //lista studentilor
    static Set<School> schoolList = new TreeSet<>((School s1, School s2) -> s1.getNameSchool().compareTo(s2.getNameSchool())); //lista scolilor ordonate dupa nume
    static Map<Student, List<School>> stdPrefMapStudent = new HashMap<>(); //mapa cu ctudentii si scolile lor preferate
    static Map<School, List<Student>> stdPrefMapSchool = new HashMap<>(); //mapa cu scolile si studentii lor preferati

    public static void studentLikeSchool(List<School> school) {  //utilizand stream, am gasit studentii carore le place de scolile din lista data
        List<Student> collect = studentList.stream().filter(e -> stdPrefMapStudent.get(e).containsAll(school)).collect(Collectors.toList());
        //daca lista data se afla in lista elevului o punem in lista collect
        System.out.print("Lista studentilor carora le place de scolile din lista este: ");
        collect.stream().forEach(e -> System.out.print(e.getNameStudent() + " ")); // aici tot cu ajutorul stream afisez lista studentilor
    }

    public static void schoolFavoriteStudent() { //utilizand stream am afisat scolile cu favoritii lor, luand primul element din lista fiecarei scoli cu studenti
        System.out.println("Scolile si favoritii lor:");
        schoolList.stream().forEach(e -> System.out.println(e.getNameSchool() + "->" + stdPrefMapSchool.get(e).get(0).getNameStudent()));
    }

    public static Student[] fakerSudentName() { //nume pentru 4 studenti
        Faker faker = new Faker();
        var students = IntStream.rangeClosed(0, 3).mapToObj(i -> new Student(faker.name().fullName())).toArray(Student[]::new);
        return students;
    }

    public static School[] fakerSchoolName() { //nume pentru 3 scoli
        Faker faker = new Faker();
        var schools = IntStream.rangeClosed(0, 2).mapToObj(i -> new School(faker.name().fullName())).toArray(School[]::new);
        return schools;
    }

    public static void main(String[] args) {
        var students = IntStream.rangeClosed(0, 3).mapToObj(i -> new Student("S" + i)).toArray(Student[]::new);
        studentList.addAll(Arrays.asList(students));
        Collections.sort(studentList, Comparator.comparing(Student::getNameStudent));
        var schools = IntStream.rangeClosed(0, 2).mapToObj(i -> new School("H" + i)).toArray(School[]::new);
        schoolList.addAll(Arrays.asList(schools));
        stdPrefMapStudent.put(students[0], Arrays.asList(schools[0], schools[1], schools[2])); //setez preferintele elevilor
        stdPrefMapStudent.put(students[1], Arrays.asList(schools[0], schools[1], schools[2]));
        stdPrefMapStudent.put(students[2], Arrays.asList(schools[0], schools[1]));
        stdPrefMapStudent.put(students[3], Arrays.asList(schools[0], schools[2]));

        stdPrefMapSchool.put(schools[0], Arrays.asList(students[3], students[0], students[1], students[2])); //setez preferintele scolilor
        stdPrefMapSchool.put(schools[1], Arrays.asList(students[0], students[2], students[1]));
        stdPrefMapSchool.put(schools[2], Arrays.asList(students[0], students[1], students[3]));

        stdPrefMapStudent.entrySet().forEach(i -> {
            System.out.print(i.getKey().getNameStudent() + ": (");
            List<School> prefListSchool = i.getValue();
            prefListSchool.forEach(j -> {
                System.out.print(j.getNameSchool() + " ");
            });
            System.out.println(")");
        });  

        stdPrefMapSchool.entrySet().forEach(i -> {
            System.out.print(i.getKey().getNameSchool() + ": (");
            List<Student> prefListStudent = i.getValue();
            prefListStudent.forEach(j -> {
                System.out.print(j.getNameStudent() + " ");
            });
            System.out.println(")");
        });

        schools[0].setCapacity(1); //setez capacitatea fiecarei scoli
        schools[1].setCapacity(2);
        schools[2].setCapacity(2);

        Problem pb = new Problem();
        pb.setStdPrefMapSchool(stdPrefMapSchool); //adaug la pb lista studentilor cu preferinte
        pb.setStdPrefMapStudent(stdPrefMapStudent); //adaug la pb lista scolilor cu preferinte

        Solution sol = new Solution(pb);
        /*
        sol.solve();
        System.out.print(sol);
         */

        students[0].setGrade(9.75); //setez nota fiecarui elev
        students[1].setGrade(8.75);
        students[2].setGrade(9);
        students[3].setGrade(6);

        /*sol.admisionByGrade();
        System.out.println(sol);
         */
        studentLikeSchool(Arrays.asList(schools[0])); //afisez lista elevilor ce le place scoala 0
        schoolFavoriteStudent(); // afisez preferatii fiecarei scoli

        schools[0].setMinGrade(8); //setez criteriul propriu al unei scoli
        schools[1].setMinGrade(7);
        schools[2].setMinGrade(7.5);

        /*sol.admisionCriteria();
        System.out.print(sol);
         */
        
        /*sol.stableMatching();
        System.out.print(sol);
         */
        
        Map<Integer, List<School>> listSchool = new HashMap<>();
        Map<Student, Map<Integer, List<School>>> studentPref = new HashMap<>(); //aici setez preferintele fiecarui student
        //folosind un map in alt map, studentul poate spune daca are 2 scoli pe care le considera de preferinta egale

        listSchool.put(0, Arrays.asList(schools[0]));
        listSchool.put(1, Arrays.asList(schools[1], schools[2]));

        studentPref.put(students[0], listSchool);

        listSchool = new HashMap<>();
        listSchool.put(0, Arrays.asList(schools[0]));
        listSchool.put(1, Arrays.asList(schools[1]));
        listSchool.put(2, Arrays.asList(schools[2]));
        studentPref.put(students[1], listSchool);

        listSchool = new HashMap<>();
        listSchool.put(0, Arrays.asList(schools[0]));
        listSchool.put(1, Arrays.asList(schools[1]));
        studentPref.put(students[2], listSchool);

        listSchool = new HashMap<>();
        listSchool.put(0, Arrays.asList(schools[0]));
        listSchool.put(1, Arrays.asList(schools[2]));
        studentPref.put(students[3], listSchool);

        sol.preferencesNotStrict(studentPref);
        System.out.print(sol);
    }
}

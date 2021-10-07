/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab4_java;

import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Bogdan
 */
public class Solution {

    private Map<Student, School> solution = new HashMap<>(); //aici vom retine repartizarile
    private Problem pb;

    public Solution(Problem pb) {
        this.pb = pb;
    }

    /**
     * @return the solution
     */
    public Map<Student, School> getSolution() {
        return solution;
    }

    public void solve() { //aici este o rezolvare simpla de tipul, primul venit, primul servit
        Map<School, List<Student>> stdPrefMapSchool = pb.getStdPrefMapSchool();
        List<Student> assigned = new ArrayList<>();
        stdPrefMapSchool.entrySet().forEach(i -> {
            List<Student> prefListStudent = i.getValue();
            prefListStudent.forEach(j -> {
                if (!assigned.contains(j) && i.getKey().getCapacity() != 0) { //verific daca nu a fost repartizat si ca scoala mai poate accepta studenti
                    assigned.add(j); //retin ca acest student a fost repartizat
                    i.getKey().setCapacity(i.getKey().getCapacity() - 1); //scad capacitatea scolii
                    solution.put(j, i.getKey()); //adaug repartizarea facuta
                }
            }
            );
        });
    }

    public void admisionByGrade() { //aici vom face repartizarile dupa nota fiecarui student
        List<Student> studentList = new ArrayList<>();
        pb.getStdPrefMapStudent().entrySet().forEach(i -> {
            studentList.add(i.getKey());
        });
        List<Student> assigned = new ArrayList<>();
        Collections.sort(studentList, Comparator.comparing(Student::getGrade).reversed()); //sortez descrescator elevii dupa note
        studentList.forEach(i -> {
            List<School> prefListSchool = pb.getStdPrefMapStudent().get(i);
            prefListSchool.forEach(j -> {
                if (j.getCapacity() != 0 && !assigned.contains(i)) {
                    solution.put(i, j); //adaug repartizarea facuta
                    j.setCapacity(j.getCapacity() - 1); //scad capacitatea scolii
                    assigned.add(i); //retin ca acest student a fost repartizat
                }
            });
        });
    }

    public void admisionCriteria() { //aici vom face repartizarile dupa criteria proprie a scolii
        List<Student> studentList = new ArrayList<>();
        pb.getStdPrefMapStudent().entrySet().forEach(i -> {
            studentList.add(i.getKey());
        });
        List<Student> assigned = new ArrayList<>();
        Collections.sort(studentList, Comparator.comparing(Student::getGrade).reversed()); //sortez descrescator elevii dupa note
        studentList.forEach(i -> {
            List<School> prefListSchool = pb.getStdPrefMapStudent().get(i);
            prefListSchool.forEach(j -> {
                if (j.getCapacity() != 0 && !assigned.contains(i) && j.getMinGrade() <= i.getGrade()) {
                    //verific daca nu a fost repartizat, ca scoala mai poate accepta studenti si ca respecta gradul minim al scolii
                    solution.put(i, j); //adaug repartizarea facuta
                    j.setCapacity(j.getCapacity() - 1); //scad capacitatea scolii
                    assigned.add(i); //retin ca acest student a fost repartizat
                }
            });
        });
    }

    public int[][] matrixPrefer() { //construiesc matricea in functie de preferinte
        int m = pb.getStdPrefMapSchool().size();
        int n = pb.getStdPrefMapStudent().size();
        int[][] prefer = new int[n + m][n];
        List<Student> studentList = new ArrayList<>();
        List<School> schoolList = new ArrayList<>();

        pb.getStdPrefMapStudent().entrySet().forEach(i -> {
            studentList.add(i.getKey());
        });

        pb.getStdPrefMapSchool().entrySet().forEach(i -> {
            schoolList.add(i.getKey());
        });

        for (int i = 0; i <= n + m - 1; i++) {
            for (int j = 0; j <= n - 1; j++) {
                prefer[i][j] = -1;
            }
        }

        for (int i = 0; i <= n - 1; i++) {
            Student student = studentList.get(i);
            List<School> prefListSchool = pb.getStdPrefMapStudent().get(student);
            int row = parseInt(student.getNameStudent().substring(1));
            for (int j = 0; j <= prefListSchool.size() - 1; j++) {
                School school = prefListSchool.get(j);
                int k = parseInt(school.getNameSchool().substring(1)) + n;
                prefer[row][j] = k;
            }
        }

        for (int i = n; i <= n + m - 1; i++) {
            School school = schoolList.get(i - n);
            List<Student> prefListStudent = pb.getStdPrefMapSchool().get(school);
            int row = parseInt(school.getNameSchool().substring(1)) + n;
            for (int j = 0; j <= prefListStudent.size() - 1; j++) {
                Student student = prefListStudent.get(j);
                int k = parseInt(student.getNameStudent().substring(1));
                prefer[row][j] = k;
            }
        }

        return prefer;
    }

    public boolean PrefersM1OverM(int[][] prefer, int s, int m, int m1, int n) { //verific daca prefera m1 mai mult decat m
        for (int i = 0; i <= n - 1; i++) {
            if (prefer[s][i] == m1) {
                return true;
            }
            if (prefer[s][i] == m) {
                return false;
            }
        }
        return false;
    }

    public int[] capacity() { //returneaza un vector cu capacitatile fiecarei scoli
        int[] capacity = new int[pb.getStdPrefMapSchool().size()];
        pb.getStdPrefMapSchool().entrySet().forEach(i -> {
            int k = parseInt(i.getKey().getNameSchool().substring(1));
            capacity[k] = i.getKey().getCapacity();
        });
        return capacity;
    }

    public void stableMatching() { 
        int[][] prefer = matrixPrefer();
        int n = pb.getStdPrefMapStudent().size();
        int m = pb.getStdPrefMapSchool().size();

        int[] studentSchool = new int[n];

        int[] freeSchool = new int[m];
        freeSchool = capacity();

        int freeSc = m;
        int freeSt = n;

        Arrays.fill(studentSchool, -1);

        while (freeSc > 0 && freeSt > 0) { //cat timp mai sunt studenti nerepartizati sau scoli libere
            int k;
            for (k = 0; k <= m - 1; k++) {
                if (freeSchool[k] != 0) {
                    break;
                }
            }

            for (int i = 0; i <= n - 1 && freeSchool[k] != 0; i++) {
                int school = prefer[k][i];
                if (school == -1); else if (studentSchool[school - n] == -1) {
                    studentSchool[school - n] = k;
                    freeSchool[k]--; //scad capacitatea
                    if (freeSchool[k] == 0) {
                        freeSc--;
                    }
                    freeSt--; //scad numarul de studenti nerepartizati
                } else {
                    int k1 = studentSchool[school - n];
                    if (!PrefersM1OverM(prefer, school, k, k1, n)) { //daca nu il prefera mai mult k fata de k1
                        studentSchool[school - n] = k;
                        freeSchool[k]--; //scad capacitatea scolii k
                        freeSchool[k1]++; //cresc capacitatea scolii k1
                        if (freeSchool[k] == 0) {
                            freeSc--;
                        }
                        if (freeSchool[k1] == 1) {
                            freeSc++;
                        }
                        freeSt--; //scad numarul de studenti nerepartizati
                    }
                }
            }
        }
        for (int i = 0; i <= n - 1; i++) {
            if (studentSchool[i] != -1) {
                solution.put(new Student("S" + i), new School("H" + studentSchool[i])); //adaug solutia problemei pentru a putea mfi mai apoi afisata
            }
        }
    }

    public void preferencesNotStrict(Map<Student, Map<Integer, List<School>>> map) { 
    //daca preferintele nu sunt stricte vom avea pe locul 1 un numar de k1 scoli, la 2 un numar de k2 scoli si tot asa...
        Map<Student, Map<Integer, List<School>>> studentPref = map;
        List<Student> assigned = new ArrayList<>();
        studentPref.entrySet().forEach((var i) -> {
            Map<Integer, List<School>> listSchools = i.getValue();
            Student student = i.getKey();
            for (int j = 0; j <= listSchools.size() - 1; j++) { 
                List<School> list = listSchools.get(j);
                if (list.size() == 1) { //daca pe acest loc studentul are o singura scoala preferata
                    School school = list.get(0); 
                    if (school.getCapacity() != 0 && !assigned.contains(student)) {
                        //verific daca nu a fost repartizat si ca mai este loc in scoala
                        solution.put(student, school); //agaug repartizarea la solutie
                        school.setCapacity(school.getCapacity() - 1); //scad capacitatea scolii
                        assigned.add(student);
                    }
                } else { //daca pe acest loc studentul are mai mult de o singura scoala preferata
                    boolean[] chosen = new boolean[list.size()];
                    while (!Arrays.asList(chosen).contains(false)) { //cat timp putem alege o scoala de pe acest loc
                        int k;
                        School school;
                        Random random = new Random(); //alegem random una dintre scoli
                        k = random.nextInt(list.size()); 
                        school = list.get(k);
                        chosen[k] = true;
                        if (school.getCapacity() != 0 && !assigned.contains(student)) {
                            //verific daca nu a fost repartizat si ca mai este loc in scoala
                            solution.put(student, school);
                            school.setCapacity(school.getCapacity() - 1);
                            assigned.add(student);
                            break;
                        }
                    }
                }
            }
        });

    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        solution.entrySet().forEach(i -> {
            s.append(i.getKey().getNameStudent());
            s.append(" : ");
            s.append(i.getValue().getNameSchool());
            s.append("\n");
        });
        return s.toString();
    }
}

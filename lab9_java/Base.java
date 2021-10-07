/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab9_java;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author Bogdan
 */
public class Base {
    static EntityManagerFactory emf;
    EntityManager em;
    
    private Base(){}
    
    @BeforeAll
    public static void beforeAll() {
        emf = Persistence.createEntityManagerFactory("lab9");
    }
    
    @AfterAll
    public static void afterAll() {
        emf.close();
    }
    
    @BeforeAll
    public void beforeEach(){
        em = emf.createEntityManager();
    }
    
    @AfterEach
    public void afterEach(){
        em.close();
    }
    
}

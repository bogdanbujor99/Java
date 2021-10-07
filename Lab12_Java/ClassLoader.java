/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab12_java;

import java.net.URL;
import java.net.URLClassLoader;

/**
 *
 * @author Bogdan
 */
public class ClassLoader extends URLClassLoader{
    public ClassLoader() {
        super(new URL[0], ClassLoader.getSystemClassLoader());
    }
    @Override
        public void addURL(URL url) {
        super.addURL(url);
    }
}

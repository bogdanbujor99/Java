package com.mycompany.lab12_java;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bogdan
 */
public class Main {
    static ClassLoader loader;
    public static void main(String []args) throws MalformedURLException, ClassNotFoundException{
        File path = new File("C:\\Users\\Bogdan\\OneDrive\\Documente\\NetBeansProjects\\lab12_java\\target\\classes\\com\\mycompany\\lab12_java");
        if(path.exists()) {
            URL url = path.toURI().toURL();
            loader.addURL(url);
        }
        Class clazz = Class.forName(loader.getURLs()[0].toString());
        Method[] methods = clazz.getMethods();
        
        for(Method m : methods){
            if(m.isAnnotationPresent(Test.class) && Modifier.isStatic(m.getModifiers()) && m.getParameterCount()==0){
                try {
                    m.invoke(null);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                catch (Throwable ex) {
                    System.out.printf("Test %s failed: %s %n",
                    m, ex.getCause());
                }
            }
        }
    }
}

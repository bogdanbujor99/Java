/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab5_java;

import java.io.IOException;

/**
 *
 * @author Bogdan
 */
public class InvalidCatalogException extends Exception {
    public InvalidCatalogException(Exception ex) {
        super("Invalid catalog file.", ex);
    }
}

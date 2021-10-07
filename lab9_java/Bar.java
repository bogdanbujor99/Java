/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab9_java;

import java.awt.Color;

/**
 *
 * @author Bogdan
 */
public class Bar {
    
        private String label;
        private double value;
        private Color color;

        public Bar(String label, double value, Color color)
        {
            this.label = label;
            this.value = value;
            this.color = color;
        }

        public String getLabel()
        {
            return label;
        }

        public double getValue()
        {
            return value;
        }

        public Color getColor()
        {
            return color;
        }
}

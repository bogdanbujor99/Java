/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab6_java;

import java.awt.geom.Ellipse2D;

/**
 *
 * @author Bogdan
 */
public class NodeShape extends Ellipse2D.Double {

    public NodeShape(double x0, double y0, double radius) {
        super(x0 - radius / 2, y0 - radius / 2, radius, radius);
    }
}

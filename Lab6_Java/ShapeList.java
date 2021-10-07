/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab6_java;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bogdan
 */
public class ShapeList { //o lista cu ce elemente se pot crea
    List<Object> list = new ArrayList<>();
    
    ShapeList(){
        list.add(RegularPolygon.class);
        list.add(ShapeList.class);
    }
}

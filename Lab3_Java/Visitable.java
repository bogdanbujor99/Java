/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab3;

import java.time.Duration;
import java.time.*;
import java.time.temporal.*;

/**
 *
 * @author Bogdan
 */
public interface Visitable {

    LocalTime getOpeningTime();

    LocalTime getClosingTime();

    default LocalTime opening() {
        return LocalTime.of(9, 30); //ora de deschidere 9:30
    }

    default LocalTime closing() {
        return LocalTime.of(20, 00); //ora de inchidere 20:00
    }

    static Duration getVisitingDuration(Visitable v) {
        Duration d;
        if (v.getClosingTime() == LocalTime.MIDNIGHT) { //daca se inchide la miezeul noptii adaug 24 de ore la diferenta ca sa fiseze timpuul corect
            Duration d1 = Duration.between(v.getOpeningTime(), v.getClosingTime());
            d = d1.plus(24, ChronoUnit.HOURS);
        } else if (v.getOpeningTime() == LocalTime.MIDNIGHT) { //daca se deschide la miezul noptii aduag 24 de ore la diferenta ca sa afiseze timpul corect
            Duration d1 = Duration.between(v.getClosingTime(), v.getOpeningTime());
            d = d1.plus(24, ChronoUnit.HOURS);
        } else {
            d = Duration.between(v.getOpeningTime(), v.getClosingTime()); //altel fac diferenta 
        }
        return d;
    }
}

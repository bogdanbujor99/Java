/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab3;

import java.time.LocalTime;

/**
 *
 * @author Bogdan
 */
public class Church extends Location implements Visitable {
    private LocalTime openingTime, closingTime;

    public Church() {
        setName("v"+this.i);
        this.i++;
    }

    /**
     * @return the openingTime
     */
    @Override
    public LocalTime getOpeningTime() {
        return openingTime;
    }

    /**
     * @param openingTime the openingTime to set
     */
    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    /**
     * @return the closingTime
     */
    @Override
    public LocalTime getClosingTime() {
        return closingTime;
    }

    /**
     * @param closingTime the closingTime to set
     */
    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

}

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
public class Museum extends Location implements Visitable, Payable {

    private LocalTime openingTime, closingTime;
    private double ticketPrice;

    public Museum() {
        setName("v" + this.i);
        this.i++;
    }

    /**
     * @return the openingTime
     */
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
    public LocalTime getClosingTime() {
        return closingTime;
    }

    /**
     * @param closingTime the closingTime to set
     */
    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    /**
     * @return the ticketPrice
     */
    public double getTicketPrice() {
        return ticketPrice;
    }

    /**
     * @param ticketPrice the ticketPrice to set
     */
    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}

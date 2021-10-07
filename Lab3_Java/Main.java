/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab3;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bogdan
 */
public class Main {

    public static void main(String[] args) {
        Museum m = new Museum();
        m.setOpeningTime(LocalTime.of(9, 30));
        m.setClosingTime(LocalTime.parse("17:00"));
        m.setTicketPrice(20);

        Church c = new Church();
        c.setOpeningTime(LocalTime.MIDNIGHT);
        c.setClosingTime(LocalTime.of(6, 0));

        Church c1 = new Church();
        c1.setOpeningTime(LocalTime.of(6, 0));
        c1.setClosingTime(LocalTime.of(23, 59));

        Restaurant r1 = new Restaurant();
        r1.setRank(4.5);

        Restaurant r = new Restaurant();
        r.setRank(3.5);

        Hotel h = new Hotel();
        h.setRank(4.9);

        Hotel h1 = new Hotel();
        h1.setRank(4);

        City iasi = new City();
        iasi.addLocation(m);
        iasi.addLocation(c);
        iasi.addLocation(c1);
        iasi.addLocation(r);
        iasi.addLocation(r1);
        iasi.addLocation(h);
        iasi.addLocation(h1);

        m.setCost(r1, 5);
        m.setCost(r, 10);
        m.setCost(h1, 30);

        c.setCost(r1, 10);
        c.setCost(h, 5);

        c1.setCost(r1, 15);

        r.setCost(h, 10);

        r1.setCost(m, 5);
        r1.setCost(h1, 30);

        h.setCost(c1, 20);

        h1.setCost(m, 30);

        List<Location> list = iasi.getNodes();

        //Mai jos este afisarea obictivelor si traseelor
        for (Location l : list) {
            System.out.println(l.getName());
            if (!l.toString().equals("")) {
                System.out.print(l.toString());
            }
        }

        //Afiseaza cat este deschis magazinul
        Duration d = Visitable.getVisitingDuration(c1);
        System.out.println(d);

        List<Location> listPref = new ArrayList<Location>();
        listPref.add(m);
        listPref.add(c);
        listPref.add(c1);
        listPref.add(h);
        TravelPlan travel = new TravelPlan(iasi, listPref);
        travel.shortestPath(); //afiseaza cel mai scurt drum intre locatiile preferate
    }

}

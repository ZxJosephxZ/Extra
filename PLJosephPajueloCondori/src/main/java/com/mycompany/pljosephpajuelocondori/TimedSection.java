/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pljosephpajuelocondori;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Joseph
 */
public class TimedSection {
     private final Semaphore sectionSemaphore = new Semaphore(4);

    public void enterSection(RallyCar car) throws InterruptedException {
        sectionSemaphore.acquire();
        try {
            System.out.println(car.getCarId() + " está entrando al tramo cronometrado");
            for (int i = 1; i <= 4; i++) {
                int sectorTime = ThreadLocalRandom.current().nextInt(4000, 10000);
                if (!car.hasCorrectTires("soleado")) {
                    sectorTime *= 3;
                }
                System.out.println(car.getCarId() + " está en el sector " + i);
                Thread.sleep(sectorTime);
            }
            System.out.println(car.getCarId() + " ha completado el tramo cronometrado");
        } finally {
            sectionSemaphore.release();
        }
    }
}

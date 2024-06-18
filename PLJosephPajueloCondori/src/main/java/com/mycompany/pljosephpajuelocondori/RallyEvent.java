/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pljosephpajuelocondori;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author Joseph
 */
public class RallyEvent {
    public static void main(String[] args) {
        GasStation gasStation = new GasStation();
        TimedSection timedSection = new TimedSection();

        for (int i = 1; i <= 5; i++) {
            new RallyCar(i, timedSection).start();
        }

        for (int i = 1; i <= 2; i++) {
            new FuelTruck(i, gasStation).start();
        }
    }
}

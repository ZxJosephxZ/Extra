/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pljosephpajuelocondori;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Joseph
 */
public class GasStation {
    private int fuelAmount = 500;
    private final Semaphore pumps = new Semaphore(5);
    private final Lock fuelLock = new ReentrantLock();

    public void refuelVehicle(RallyCar car) throws InterruptedException {
        pumps.acquire();
        try {
            fuelLock.lock();
            try {
                int neededFuel = car.getFuelCapacity() - car.getCurrentFuel();
                if (fuelAmount >= neededFuel) {
                    fuelAmount -= neededFuel;
                    car.refuel(neededFuel);
                } else {
                    car.refuel(fuelAmount);
                    fuelAmount = 0;
                }
            } finally {
                fuelLock.unlock();
            }
            Thread.sleep(ThreadLocalRandom.current().nextInt(3000, 5000));
        } finally {
            pumps.release();
        }
    }

    public void refuelStation(FuelTruck truck) throws InterruptedException {
        Thread.sleep(ThreadLocalRandom.current().nextInt(5000, 10000));
        fuelLock.lock();
        try {
            fuelAmount += truck.getCurrentFuel();
            truck.setCurrentFuel(0);
        } finally {
            fuelLock.unlock();
        }
    }
}

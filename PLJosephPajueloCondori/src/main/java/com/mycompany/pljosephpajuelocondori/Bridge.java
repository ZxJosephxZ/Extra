/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pljosephpajuelocondori;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Joseph
 */
public class Bridge {
    private final Semaphore semaphore = new Semaphore(10);
    private boolean lastDirectionLeft = false;

    public void crossBridge(String vehicleId) throws InterruptedException {
        semaphore.acquire();
        try {
            System.out.println(vehicleId + " está cruzando el puente");
            Thread.sleep(5000); // Tiempo de cruce
        } finally {
            semaphore.release();
        }
    }

    public synchronized boolean getDirection() {
        lastDirectionLeft = !lastDirectionLeft;
        return lastDirectionLeft;
    }
}

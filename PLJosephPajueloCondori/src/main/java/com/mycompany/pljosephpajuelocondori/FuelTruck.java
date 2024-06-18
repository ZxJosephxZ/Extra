/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pljosephpajuelocondori;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Joseph
 */
public class FuelTruck extends Thread{
    private String truckId;
    private int fuelCapacity;
    private int currentFuel;
    private GasStation gasStation;
    
    public FuelTruck(int id, GasStation gasStation){
        this.truckId = "CC-" + String.format("%04d", id);
        this.fuelCapacity = 1000;
        this.currentFuel = ThreadLocalRandom.current().nextInt(500, 1001); //Entre 50%
        this.gasStation = gasStation;
    }
    
    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                //cargar combustible
                System.out.println(this.truckId + "esta cargando combustible en la ciudad");
                Thread.sleep(ThreadLocalRandom.current().nextInt(3000,5000));
                
                moveToParking();
                
                gasStation.refuelStation(this);
                
                returnToCity();
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
    
    private void moveToParking() throws InterruptedException
    {
        System.out.println(this.truckId + "esta yendo al parking");
        Thread.sleep(ThreadLocalRandom.current().nextInt(5000,10000));
    }
    private void returnToCity() throws InterruptedException
    {
        System.out.println(this.truckId + "esta regresando a la ciudad");
        Thread.sleep(ThreadLocalRandom.current().nextInt(5000,10000));

    }
    public int getCurrentFuel()
    {
        return currentFuel;
    }
    public void setCurrentFuel(int currentFuel)
    {
        this.currentFuel = currentFuel;
    }
}

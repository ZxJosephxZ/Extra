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
public class RallyCar extends Thread{
    private static final String[] CLIMATES = {"soleado", "lluvia", "nieve"};
    private String carId;
    private int fuelCapacity;
    private String tireType;
    private int currentFuel;
    private String climate;
    private static final Random random = new Random();
    private TimedSection timedSection;
    
    public RallyCar(int id, TimedSection timedSection)
    {
        this.carId = String.format("%04d-%s", id, generateRandomLetters(3));
        this.fuelCapacity = ThreadLocalRandom.current().nextInt(75, 131);
        this.currentFuel = ThreadLocalRandom.current().nextInt(25, 51);
        this.tireType = CLIMATES[random.nextInt(CLIMATES.length)];
        this.timedSection = timedSection;
    }
    /**
    private String generateLicensePlate(int id)
    {
        String number = String.format("%04d", id);
        String letters = generateRandomLetters();
        return number + "-" + letters;
    }*/
    
    private String generateRandomLetters(int length)
    {
        String letters = "BCDFGHJKLMNPQRSTVWXYZ";
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(letters.charAt(random.nextInt(letters.length())));
        }
        return sb.toString();
    }
    
    @Override
    public void run()
    {
        while (true) {
            try {
                // Parking
                System.out.println(this.carId + " está en el parking");
                Thread.sleep(ThreadLocalRandom.current().nextInt(3000, 5000));

                // Verificaciones técnicas en el parking
                System.out.println(this.carId + " está siendo verificado en el parking.");
                Thread.sleep(ThreadLocalRandom.current().nextInt(3000, 5000));

                // Move to the section
                moveToSection();

                // Enter timed section
                timedSection.enterSection(this);

                // Return to parking
                System.out.println(this.carId + " está regresando al parking");
                Thread.sleep(ThreadLocalRandom.current().nextInt(3000, 5000));

                // Rest
                System.out.println(this.carId + " está descansando en el parking");
                Thread.sleep(ThreadLocalRandom.current().nextInt(5000, 10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void moveToSection() throws InterruptedException
    {
        //from parking to bridge
        System.out.println(this.carId + "esta yendo al puente");
        Thread.sleep(ThreadLocalRandom.current().nextInt(3000,5000));
        
        //from bridge to gas station
        System.out.println(this.carId + "esta yendo a la gasolineria");
        Thread.sleep(ThreadLocalRandom.current().nextInt(3000,5000));
        refuelIfNecessary();
    }
    
    private void refuelIfNecessary() throws InterruptedException
    {
        if (currentFuel < fuelCapacity / 2)
        {
            System.out.println(this.carId + "esta repostando");
            Thread.sleep(ThreadLocalRandom.current().nextInt(3000,5000));
            currentFuel = fuelCapacity;
        }
        else
        {
            System.out.println(this.carId + "no necesita repostar");
        }
    }
    
    public boolean hasCorrectTires(String climate)
    {
        return this.tireType.equals(climate);
    }
    
    public String getCarId() {
        return carId;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public int getCurrentFuel() {
        return currentFuel;
    }

    public void refuel(int amount) {
        this.currentFuel += amount;
    }
    /**
    public static void main(String[] args)
    {
        RallyCar car = new RallyCar(1);
        car.start();
    }
    **/
}

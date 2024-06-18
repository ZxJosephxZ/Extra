/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pljosephpajuelocondori;

/**
 *
 * @author Joseph
 */
public class Parking {
    public void parkVehicle(String vehicleId, int sleepTime) throws InterruptedException {
        System.out.println(vehicleId + " está en el parking");
        Thread.sleep(sleepTime);
    }
}

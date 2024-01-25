package com.javaacademy.toyota.car.detail;

/**
 * Бак
 */
public class Tank {
    private double fuel = 0;

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        if (fuel < 0) {
            throw new RuntimeException("Fuel cannot be minus count");
        }
        this.fuel = fuel;
    }
}

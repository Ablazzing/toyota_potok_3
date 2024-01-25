package com.javaacademy.toyota.car.type;

import com.javaacademy.toyota.Country;
import com.javaacademy.toyota.car.detail.TransmissionType;
import com.javaacademy.toyota.car.detail.WheelDiameter;
import com.javaacademy.toyota.shop.CarModel;

/**
 * Абстрактная грузовая машина
 */
public abstract class Truck extends Car {
    private final int maxCapacity;

    public Truck(String color, int maxSpeed, TransmissionType transmissionType,
                 WheelDiameter wheelDiameter, int maxCapacity,
                 Country countryAssembly, CarModel carModel) {
        super(color, maxSpeed, transmissionType, wheelDiameter, countryAssembly, carModel);
        this.maxCapacity = maxCapacity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }
}


package com.javaacademy.toyota.car.model;

import com.javaacademy.toyota.Country;
import com.javaacademy.toyota.car.detail.TransmissionType;
import com.javaacademy.toyota.car.detail.Wheel;
import com.javaacademy.toyota.car.detail.WheelDiameter;
import com.javaacademy.toyota.car.type.Truck;
import com.javaacademy.toyota.shop.CarModel;

import static com.javaacademy.toyota.car.detail.TransmissionType.MECHANIC;
import static com.javaacademy.toyota.car.detail.WheelDiameter.TWENTY;

/**
 * Хайянс модель
 */
public class Hiance extends Truck {
    public static final WheelDiameter HIANCE_DIAMETER = TWENTY;
    public static final TransmissionType TRANSMISSION_TYPE = MECHANIC;
    public static final int MAX_SPEED =  170;
    public static final int MAX_CAPACITY = 2_000;

    private Wheel safeWheel;

    public Hiance(String color, Country countryAssembly) {
        super(color, MAX_SPEED, TRANSMISSION_TYPE, TWENTY, MAX_CAPACITY, countryAssembly,
                CarModel.HIANCE);
    }

    public Wheel getSafeWheel() {
        return safeWheel;
    }

    public void setSafeWheel(Wheel safeWheel) {
        checkWheel(safeWheel);
        this.safeWheel = safeWheel;
    }
}

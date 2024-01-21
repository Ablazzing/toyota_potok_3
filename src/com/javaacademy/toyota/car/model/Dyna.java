package com.javaacademy.toyota.car.model;

import com.javaacademy.toyota.car.detail.TransmissionType;
import com.javaacademy.toyota.car.detail.WheelDiameter;
import com.javaacademy.toyota.car.type.Truck;

import static com.javaacademy.toyota.car.detail.WheelDiameter.TWENTY;

public class Duna extends Truck {
    private static final WheelDiameter DYNA_DIAMETER = TWENTY;

    public Duna(String color, int maxSpeed, TransmissionType transmissionType, WheelDiameter wheelDiameter, int maxCapacity) {
        super(color, maxSpeed, transmissionType, wheelDiameter, maxCapacity);
    }
}

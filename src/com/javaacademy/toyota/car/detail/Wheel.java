package com.javaacademy.toyota.car.detail;

/**
 * Колесо
 */
public class Wheel extends CrushDetail {
    private final WheelDiameter wheelDiameter;

    public Wheel(WheelDiameter wheelDiameter) {
        this.wheelDiameter = wheelDiameter;
    }

    public WheelDiameter getWheelDiameter() {
        return wheelDiameter;
    }
}

package com.javaacademy.toyota.car.detail;

/**
 * Деталь которая может быть включена/выключена
 */
public abstract class TurnDetail {
    private boolean isOn = false;

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }
}

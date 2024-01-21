package com.javaacademy.toyota.factory;

import com.javaacademy.toyota.Country;
import com.javaacademy.toyota.car.detail.CruiseControl;
import com.javaacademy.toyota.car.detail.Electricity;
import com.javaacademy.toyota.car.detail.Engine;
import com.javaacademy.toyota.car.detail.HeadLights;
import com.javaacademy.toyota.car.detail.MiniFridge;
import com.javaacademy.toyota.car.detail.Roof;
import com.javaacademy.toyota.car.detail.Socket;
import com.javaacademy.toyota.car.detail.Tank;
import com.javaacademy.toyota.car.detail.Usb;
import com.javaacademy.toyota.car.detail.Wheel;
import com.javaacademy.toyota.car.detail.WheelDiameter;

public class Factory {
    private final Country country;

    public Factory(Country country) {
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }

    public Usb createUsb() {
        return new Usb();
    }

    public Engine createEngine() {
        return new Engine();
    }

    public Electricity createElectricity() {
        return new Electricity();
    }

    public HeadLights createHeadLights() {
        return new HeadLights();
    }

    public Wheel createWheel(WheelDiameter wheelDiameter) {
        return new Wheel(wheelDiameter);
    }

    public CruiseControl createCruiseControl() {
        return new CruiseControl();
    }

    public Socket createSocket() {
        return new Socket();
    }

    public Roof createRoof() {
        return new Roof();
    }

    public Tank createTank() {
        return new Tank();
    }

    public MiniFridge miniFridge() {
        return new MiniFridge();
    }
}

package com.javaacademy.toyota.car.type;

import com.javaacademy.toyota.Country;
import com.javaacademy.toyota.car.detail.Roof;
import com.javaacademy.toyota.car.detail.TransmissionType;
import com.javaacademy.toyota.car.detail.WheelDiameter;
import com.javaacademy.toyota.shop.CarModel;

/**
 * Тип машин: кабриолет
 */
public abstract class Cabriolet extends LightCar {
    private Roof roof;

    public Cabriolet(String color, int maxSpeed, TransmissionType transmissionType,
                     WheelDiameter wheelDiameter, Country countryAssembly, CarModel carModel) {
        super(color, maxSpeed, transmissionType, wheelDiameter, countryAssembly, carModel);
    }

    public Roof getRoof() {
        return roof;
    }

    public void setRoof(Roof roof) {
        this.roof = roof;
    }

    public void roofUp() {
        System.out.println("Крыша поднята");
        roof.setOn(true);
    }

    public void roofDown() {
        System.out.println("Крыша опущена");
        roof.setOn(false);
    }
}

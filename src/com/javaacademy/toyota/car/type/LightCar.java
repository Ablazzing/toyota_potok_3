package com.javaacademy.toyota.car.type;

import com.javaacademy.toyota.Country;
import com.javaacademy.toyota.car.detail.CruiseControl;
import com.javaacademy.toyota.car.detail.TransmissionType;
import com.javaacademy.toyota.car.detail.WheelDiameter;
import com.javaacademy.toyota.shop.CarModel;

/**
 * Легковой автомобиль
 */
public abstract class LightCar extends Car {
    private CruiseControl cruiseControl;

    public LightCar(String color, int maxSpeed, TransmissionType transmissionType,
                    WheelDiameter wheelDiameter, Country countryAssembly, CarModel carModel) {
        super(color, maxSpeed, transmissionType, wheelDiameter, countryAssembly, carModel);
    }

    public CruiseControl getCruiseControl() {
        return cruiseControl;
    }

    public void setCruiseControl(CruiseControl cruiseControl) {
        this.cruiseControl = cruiseControl;
    }

    public void cruiseControlOn() {
        System.out.println("Круиз контроль работает");
        cruiseControl.setOn(true);
    }

    public void cruiseControlOff() {
        System.out.println("Круиз контроль не работает");
        cruiseControl.setOn(false);
    }
}

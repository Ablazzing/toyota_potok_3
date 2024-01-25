package com.javaacademy.toyota.car.model;

import com.javaacademy.toyota.Country;
import com.javaacademy.toyota.car.detail.MiniFridge;
import com.javaacademy.toyota.car.detail.TransmissionType;
import com.javaacademy.toyota.car.detail.WheelDiameter;
import com.javaacademy.toyota.car.type.Cabriolet;
import com.javaacademy.toyota.shop.CarModel;

import static com.javaacademy.toyota.car.detail.TransmissionType.ROBOT;
import static com.javaacademy.toyota.car.detail.WheelDiameter.SIXTEEN;

/**
 * Солара модель
 */
public class Solara extends Cabriolet {
    public static final WheelDiameter SOLARA_DIAMETER = SIXTEEN;
    public static final TransmissionType TRANSMISSION_TYPE = ROBOT;
    public static final int MAX_SPEED = 300;
    private MiniFridge miniFridge;

    public Solara(String color, Country countryAssembly) {
        super(color, MAX_SPEED, TRANSMISSION_TYPE, SIXTEEN, countryAssembly, CarModel.SOLARA);
    }

    public void setMiniFridge(MiniFridge miniFridge) {
        this.miniFridge = miniFridge;
    }

    public void freezeBeverage() {
        miniFridge.freezeBeverage();
    }
}

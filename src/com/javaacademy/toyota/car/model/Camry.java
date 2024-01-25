package com.javaacademy.toyota.car.model;

import com.javaacademy.toyota.Country;
import com.javaacademy.toyota.car.detail.TransmissionType;
import com.javaacademy.toyota.car.detail.Usb;
import com.javaacademy.toyota.car.detail.WheelDiameter;
import com.javaacademy.toyota.car.type.LightCar;
import com.javaacademy.toyota.shop.CarModel;

import static com.javaacademy.toyota.car.detail.TransmissionType.AUTO;
import static com.javaacademy.toyota.car.detail.WheelDiameter.SEVENTEEN;

/**
 * Камри
 */
public class Camry extends LightCar {
    public static final WheelDiameter CAMRY_DIAMETER = SEVENTEEN;
    public static final int MAX_SPEED = 225;
    public static final TransmissionType TRANSMISSION_TYPE = AUTO;
    private Usb usb;

    public Camry(String color, int maxSpeed, TransmissionType transmissionType,
                 Country countryAssembly) {
        super(color, maxSpeed, transmissionType, CAMRY_DIAMETER, countryAssembly, CarModel.CAMRY);
    }

    public void connectMusic() {
        usb.connectMusic();
    }

    public Usb getUsb() {
        return usb;
    }

    public void setUsb(Usb usb) {
        this.usb = usb;
    }
}

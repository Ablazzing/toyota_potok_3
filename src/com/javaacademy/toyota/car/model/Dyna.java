package com.javaacademy.toyota.car.model;

import com.javaacademy.toyota.Country;
import com.javaacademy.toyota.car.detail.Socket;
import com.javaacademy.toyota.car.detail.TransmissionType;
import com.javaacademy.toyota.car.detail.WheelDiameter;
import com.javaacademy.toyota.car.type.Truck;
import com.javaacademy.toyota.shop.CarModel;

import static com.javaacademy.toyota.car.detail.TransmissionType.MECHANIC;
import static com.javaacademy.toyota.car.detail.WheelDiameter.TWENTY;

/**
 * Дюна
 */
public class Dyna extends Truck {
    public static final WheelDiameter DYNA_DIAMETER = TWENTY;
    public static final TransmissionType TRANSMISSION_TYPE = MECHANIC;
    public static final int MAX_SPEED = 150;
    public static final int MAX_CAPACITY = 3_000;
    private Socket socket;

    public Dyna(String color, Country countryAssembly) {
        super(color, MAX_SPEED, TRANSMISSION_TYPE, DYNA_DIAMETER, MAX_CAPACITY,
                countryAssembly, CarModel.DYNA);
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}

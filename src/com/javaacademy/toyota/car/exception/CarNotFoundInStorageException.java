package com.javaacademy.toyota.car.exception;

import com.javaacademy.toyota.shop.CarModel;

public class CarNotFoundInStorage extends Exception {
    private final CarModel carModel;

    public CarNotFoundInStorage(String message, CarModel carModel) {
        super(message);
        this.carModel = carModel;
    }

    public CarModel getCarModel() {
        return carModel;
    }
}

package com.javaacademy.toyota.car.exception;

import com.javaacademy.toyota.shop.CarModel;

/**
 * Ошибка: Машина отсутсвует на складе
 */
public class CarNotFoundInStorageException extends Exception {
    private final CarModel carModel;

    public CarNotFoundInStorageException(String message, CarModel carModel) {
        super(message);
        this.carModel = carModel;
    }

    public CarModel getCarModel() {
        return carModel;
    }
}

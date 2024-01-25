package com.javaacademy.toyota.storage;

import com.javaacademy.toyota.car.exception.CarNotFoundInStorageException;
import com.javaacademy.toyota.car.model.Camry;
import com.javaacademy.toyota.car.model.Dyna;
import com.javaacademy.toyota.car.model.Hiance;
import com.javaacademy.toyota.car.model.Solara;
import com.javaacademy.toyota.car.type.Car;
import com.javaacademy.toyota.shop.CarModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.javaacademy.toyota.shop.CarModel.CAMRY;
import static com.javaacademy.toyota.shop.CarModel.DYNA;
import static com.javaacademy.toyota.shop.CarModel.HIANCE;
import static com.javaacademy.toyota.shop.CarModel.SOLARA;

public class Storage {
    private static final int MAX_COUNT_CARS = 1_000;
    private int countCars = 0;
    private final Map<CarModel, List<Car>> cars = new HashMap<>();

    public void addCar(Car car) {
        if (countCars >= MAX_COUNT_CARS) {
            throw new RuntimeException("Storage is full!");
        }
        if (!cars.containsKey(car.getCarModel())) {
            cars.put(car.getCarModel(), new ArrayList<>());
        }
        cars.get(car.getCarModel()).add(car);
        countCars++;
    }

    public Camry getCamry() throws CarNotFoundInStorageException {
        return (Camry) getCar(CAMRY);
    }

    public Hiance getHiance() throws CarNotFoundInStorageException {
        return (Hiance) getCar(HIANCE);
    }

    public Solara getSolara() throws CarNotFoundInStorageException {
        return (Solara) getCar(SOLARA);
    }

    public Dyna getDyna() throws CarNotFoundInStorageException {
        return (Dyna) getCar(DYNA);
    }

    private Car getCar(CarModel carModel) throws CarNotFoundInStorageException {
        List<Car> carList = cars.get(carModel);
        if (carList != null && !carList.isEmpty()) {
            countCars--;
            return carList.remove(carList.size() - 1);
        }
        throw new CarNotFoundInStorageException("There is no car", carModel);
    }

}

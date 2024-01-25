package com.javaacademy.toyota.shop;

import com.javaacademy.toyota.car.exception.CarNotFoundInStorageException;
import com.javaacademy.toyota.car.type.Car;
import com.javaacademy.toyota.conveyor.Conveyor;
import com.javaacademy.toyota.storage.Storage;

import static com.javaacademy.toyota.shop.CarModel.CAMRY;
import static com.javaacademy.toyota.shop.CarModel.DYNA;
import static com.javaacademy.toyota.shop.CarModel.HIANCE;
import static com.javaacademy.toyota.shop.CarModel.SOLARA;

/**
 * Менеджер. Осуществляет продажу клиенту машин.
 * Прикреплен к определенным заводу и складу.
 */
public class Manager {
    private final String name;
    private Storage storage;
    private Conveyor conveyor;
    private Report report;

    public Manager(String name, Storage storage, Conveyor conveyor) {
        this.name = name;
        this.storage = storage;
        this.conveyor = conveyor;
        this.report = new Report(name);
    }

    public void createFileReport(String fileName) {
        report.createFileReport(fileName);
    }

    /**
     * Продает машину клиенту. Заносит проданную машину в отчет.
     *
     * @param consumer - покупатель.
     * @return - самую дорогую машину для клиента
     */
    public Car sellCar(Consumer consumer) {
        Car car = sellCarHelper(consumer);
        report.addSoldCar(car);
        return car;
    }

    /**
     * Вспомогательный метод для продажи машины, без привязки к типу возвращаемой машины
     *
     * @param consumer - покупатель
     * @return - самую дорогую машину для клиента
     */
    private Car sellCarHelper(Consumer consumer) {
        try {
            if (consumer.getMoney().compareTo(DYNA.getPrice()) >= 0) {
                return storage.getDyna();
            } else if (consumer.getMoney().compareTo(HIANCE.getPrice()) >= 0) {
                return storage.getHiance();
            } else if (consumer.getMoney().compareTo(SOLARA.getPrice()) >= 0) {
                return storage.getSolara();
            } else if (consumer.getMoney().compareTo(CAMRY.getPrice()) >= 0) {
                return storage.getCamry();
            }
        } catch (CarNotFoundInStorageException e) {
            return conveyor.createCar(e.getCarModel(), "black");
        }
        throw new RuntimeException("Consumer has no money for buy any car");
    }
}

package com.javaacademy.toyota;

import com.javaacademy.toyota.car.model.Camry;
import com.javaacademy.toyota.car.model.Dyna;
import com.javaacademy.toyota.car.model.Hiance;
import com.javaacademy.toyota.car.model.Solara;
import com.javaacademy.toyota.conveyor.Conveyor;
import com.javaacademy.toyota.conveyor.CountryNotEqualException;
import com.javaacademy.toyota.factory.DetailFactory;
import com.javaacademy.toyota.shop.Consumer;
import com.javaacademy.toyota.shop.Manager;
import com.javaacademy.toyota.storage.Storage;

import java.math.BigDecimal;

public class Runner {
    public static void main(String[] args) throws CountryNotEqualException {
        DetailFactory detailFactory = new DetailFactory(Country.JAPAN);
        Conveyor conveyor = new Conveyor(Country.JAPAN, detailFactory);
        Camry camry = conveyor.createCamry("Black");
        Solara solara = conveyor.createSolara("White");
        Hiance hiance = conveyor.createHiance("Black");
        Dyna dyna = conveyor.createDyna("Black");
        Storage storage = new Storage();
        storage.addCar(camry);
        storage.addCar(solara);
        storage.addCar(hiance);
        storage.addCar(dyna);
        Manager manager = new Manager("Yuri", storage, conveyor);
        Consumer consumer = new Consumer("Petr", new BigDecimal(20_000));
        Consumer consumer2 = new Consumer("Petr", new BigDecimal(22_000));
        Consumer consumer3 = new Consumer("Petr", new BigDecimal(15_000));
        Consumer consumer4 = new Consumer("Petr", new BigDecimal(10_000));
        manager.sellCar(consumer);
        manager.sellCar(consumer2);
        manager.sellCar(consumer3);
        manager.sellCar(consumer4);
        manager.createFileReport("report.txt");
    }
}

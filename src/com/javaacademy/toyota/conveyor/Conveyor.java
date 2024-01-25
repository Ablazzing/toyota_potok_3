package com.javaacademy.toyota.conveyor;

import com.javaacademy.toyota.Country;
import com.javaacademy.toyota.car.detail.Wheel;
import com.javaacademy.toyota.car.detail.WheelDiameter;
import com.javaacademy.toyota.car.model.Camry;
import com.javaacademy.toyota.car.model.Dyna;
import com.javaacademy.toyota.car.model.Hiance;
import com.javaacademy.toyota.car.model.Solara;
import com.javaacademy.toyota.car.type.Car;
import com.javaacademy.toyota.factory.DetailFactory;
import com.javaacademy.toyota.shop.CarModel;

import static com.javaacademy.toyota.car.type.Car.COUNT_WHEELS;

/**
 * Конвейер
 */
public class Conveyor {
    private static final String COUNTRY_NOT_EQUAL_TEMPLATE = "\"Country conveyor "
            + "'%s' not equals country factory '%s'\"";
    private final Country country;
    private final DetailFactory detailFactory;

    public Conveyor(Country country, DetailFactory detailFactory) throws CountryNotEqualException {
        if (country != detailFactory.getCountry()) {
            String message = String.format(COUNTRY_NOT_EQUAL_TEMPLATE, country,
                    detailFactory.getCountry());
            throw new CountryNotEqualException(message);
        }
        this.country = country;
        this.detailFactory = detailFactory;
    }

    public Camry createCamry(String color) {
        Camry camry = new Camry(color, Camry.MAX_SPEED, Camry.TRANSMISSION_TYPE, country);
        setCommonDetails(camry, Camry.CAMRY_DIAMETER);
        camry.setUsb(detailFactory.createUsb());
        return camry;
    }

    public Solara createSolara(String color) {
        Solara solara = new Solara(color, country);
        setCommonDetails(solara, Solara.SOLARA_DIAMETER);
        solara.setRoof(detailFactory.createRoof());
        solara.setMiniFridge(detailFactory.miniFridge());
        return solara;
    }

    public Dyna createDyna(String color) {
        Dyna dyna = new Dyna(color, country);
        setCommonDetails(dyna, Dyna.DYNA_DIAMETER);
        dyna.setSocket(detailFactory.createSocket());
        return dyna;
    }

    public Hiance createHiance(String color) {
        Hiance hiance = new Hiance(color, country);
        setCommonDetails(hiance, Hiance.HIANCE_DIAMETER);
        hiance.setSafeWheel(detailFactory.createWheel(Hiance.HIANCE_DIAMETER));
        return hiance;
    }
    
    public Car createCar(CarModel carModel, String color) {
        switch (carModel) {
            case CAMRY -> {
                return createCamry(color);
            }
            case SOLARA -> {
                return createSolara(color);
            }
            case DYNA -> {
                return createDyna(color);
            }
            case HIANCE -> {
                return createHiance(color);
            }
            default -> throw new RuntimeException("Car with this model is not exists");
        }
    }

    /**
     * Установка общих для всех машин деталей
     *
     * @param car - машина
     * @param wheelDiameter - диаметр колеса
     */
    private void setCommonDetails(Car car, WheelDiameter wheelDiameter) {
        car.setElectricity(detailFactory.createElectricity());
        car.setEngine(detailFactory.createEngine());
        car.setTank(detailFactory.createTank());
        car.setHeadLights(detailFactory.createHeadLights());
        car.setWheels(createWheels(wheelDiameter));
    }

    private Wheel[] createWheels(WheelDiameter wheelDiameter) {
        Wheel[] wheels = new Wheel[COUNT_WHEELS];
        for (int i = 0; i < wheels.length; i++) {
            wheels[i] = detailFactory.createWheel(wheelDiameter);
        }
        return wheels;
    }

    public Country getCountry() {
        return country;
    }
}

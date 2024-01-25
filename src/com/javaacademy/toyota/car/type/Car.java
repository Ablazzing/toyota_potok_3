package com.javaacademy.toyota.car.type;

import com.javaacademy.toyota.Country;
import com.javaacademy.toyota.car.detail.Electricity;
import com.javaacademy.toyota.car.detail.Engine;
import com.javaacademy.toyota.car.detail.HeadLights;
import com.javaacademy.toyota.car.detail.Tank;
import com.javaacademy.toyota.car.detail.TransmissionType;
import com.javaacademy.toyota.car.detail.Wheel;
import com.javaacademy.toyota.car.detail.WheelDiameter;
import com.javaacademy.toyota.car.exception.StartCarFailedException;
import com.javaacademy.toyota.shop.CarModel;

/**
 * Абстрактная машина
 */
public abstract class Car {
    public static final int COUNT_WHEELS = 4;
    private String color;
    private int maxSpeed;
    private final TransmissionType transmissionType;
    private boolean isMove = false;
    private Tank tank;
    private Engine engine;
    private Wheel[] wheels = new Wheel[COUNT_WHEELS];
    private Electricity electricity;
    private HeadLights headLights;
    private final WheelDiameter wheelDiameter;
    private final Country countryAssembly;
    private final CarModel carModel;

    public Car(String color, int maxSpeed, TransmissionType transmissionType,
               WheelDiameter wheelDiameter, Country countryAssembly,
               CarModel carModel) {
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.transmissionType = transmissionType;
        this.wheelDiameter = wheelDiameter;
        this.countryAssembly = countryAssembly;
        this.carModel = carModel;
    }

    public void start() throws StartCarFailedException {
        if (isMove) {
            throw new StartCarFailedException("Car is already start");
        }
        checkDetailsBeforeStart();
        isMove = true;
    }

    public void stop() {
        isMove = false;
    }

    private void checkDetailsBeforeStart() throws StartCarFailedException {
        StringBuilder failures = new StringBuilder();
        if (tank.getFuel() <= 0) {
            failures.append("Fuel is empty;");
        }
        if (!engine.isWork()) {
            failures.append("Engine is not work;");
        }
        if (!headLights.isWork()) {
            failures.append("Headlights is not work");
        }
        if (!electricity.isWork()) {
            failures.append("Electricity is not work");
        }
        if (!checkWheelsWork()) {
            failures.append("Wheels is not work");
        }

        if (!failures.isEmpty()) {
            throw new StartCarFailedException(failures.toString());
        }
    }

    private boolean checkWheelsWork() {
        for (Wheel wheel : wheels) {
            if (!wheel.isWork()) {
                return false;
            }
        }
        return true;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public WheelDiameter getWheelDiameter() {
        return wheelDiameter;
    }

    public Country getCountryAssembly() {
        return countryAssembly;
    }

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Wheel[] getWheels() {
        return wheels;
    }

    public void setWheels(Wheel[] wheels) {
        checkWheels(wheels);
        this.wheels = wheels;
    }

    private void checkWheels(Wheel[] wheels) {
        if (wheels == null || wheels.length != 4) {
            throw new RuntimeException("Wheels array null or not size " + COUNT_WHEELS);
        }
        for (Wheel wheel : wheels) {
            checkWheel(wheel);
        }
    }

    protected void checkWheel(Wheel wheel) {
        if (wheel == null || wheel.getWheelDiameter() != wheelDiameter) {
            throw new RuntimeException("Wheel is null or not same diameter");
        }
    }

    public Electricity getElectricity() {
        return electricity;
    }

    public void setElectricity(Electricity electricity) {
        this.electricity = electricity;
    }

    public HeadLights getHeadLights() {
        return headLights;
    }

    public void setHeadLights(HeadLights headLights) {
        this.headLights = headLights;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public TransmissionType getTransmissionType() {
        return transmissionType;
    }

    public boolean isMove() {
        return isMove;
    }

}

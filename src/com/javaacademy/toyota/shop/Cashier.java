package com.javaacademy.toyota.shop;

import com.javaacademy.toyota.car.type.Car;

import java.math.BigDecimal;

/**
 * Кассир
 */
public class Cashier {
    private static BigDecimal income = new BigDecimal(0);

    /**
     * Добавление стоимости продажи машины в общий счет доходов
     *
     * @param car - машина, цену которой нужно вытащить в счет общих доходов
     */
    public void addIncome(Car car) {
        income = income.add(car.getCarModel().getPrice());
    }
}

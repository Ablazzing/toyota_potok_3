package com.javaacademy.toyota.shop;

import java.math.BigDecimal;

/**
 * Модель машины (содержит цену продажи и стоимость производства)
 */
public enum CarModel {
    CAMRY(new BigDecimal(10_000), new BigDecimal(5_000)),
    SOLARA(new BigDecimal(12_000), new BigDecimal(8_000)),
    HIANCE(new BigDecimal(15_000), new BigDecimal(10_000)),
    DYNA(new BigDecimal(22_000), new BigDecimal(12_000));

    private final BigDecimal price;
    private final BigDecimal factoryCost;

    CarModel(BigDecimal price, BigDecimal factoryCost) {
        this.price = price;
        this.factoryCost = factoryCost;
    }

    public BigDecimal getFactoryCost() {
        return factoryCost;
    }

    public BigDecimal getPrice() {
        return price;
    }
}

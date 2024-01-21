package com.javaacademy.toyota.shop;

import java.math.BigDecimal;

public enum CarPrice {
    CAMRY(new BigDecimal(10_000)),
    SOLARA(new BigDecimal(12_000)),
    HIANCE(new BigDecimal(15_000)),
    DYNA(new BigDecimal(22_000));

    private BigDecimal price;

    CarPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }
}

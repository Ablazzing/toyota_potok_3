package com.javaacademy.toyota.shop;

import java.math.BigDecimal;

/**
 * Потребитель
 */
public class Consumer {
    private final String name;
    private BigDecimal money;

    public Consumer(String name, BigDecimal money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}

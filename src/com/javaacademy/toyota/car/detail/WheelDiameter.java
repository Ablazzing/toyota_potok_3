package com.javaacademy.toyota.car.detail;

/**
 * Диаметр колеса
 */
public enum WheelDiameter {
    SIXTEEN(16), SEVENTEEN(17), TWENTY(20);
    private final int size;

    WheelDiameter(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}

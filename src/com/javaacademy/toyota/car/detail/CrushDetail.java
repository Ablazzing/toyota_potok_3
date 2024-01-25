package com.javaacademy.toyota.car.detail;

/**
 * Детали, которые могут ломаться
 */
public abstract class CrushDetail {
    private boolean isWork = true;

    public boolean isWork() {
        return isWork;
    }

    public void setWork(boolean work) {
        isWork = work;
    }
}

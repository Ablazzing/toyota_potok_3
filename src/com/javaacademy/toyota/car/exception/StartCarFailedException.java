package com.javaacademy.toyota.car.exception;

/**
 * Машине не может начать движение
 */
public class StartCarFailedException extends Exception {
    public StartCarFailedException(String message) {
        super(message);
    }
}

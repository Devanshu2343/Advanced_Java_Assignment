package com.example.demo.exception;

public class ShipmentProcessingException extends RuntimeException {

    public ShipmentProcessingException(String message) {
        super(message);
    }
}
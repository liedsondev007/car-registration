package com.challenger.api_car.excepitions;

public class CarServiceException extends RuntimeException {

    public CarServiceException(String message) {
        super(message);
    }

    public CarServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}

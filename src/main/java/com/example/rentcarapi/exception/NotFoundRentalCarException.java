package com.example.rentcarapi.exception;

public class NotFoundRentalCarException extends RuntimeException {

    public NotFoundRentalCarException(String message) {
        super(message);
    }
}

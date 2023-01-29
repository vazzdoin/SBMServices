package com.service.hotel.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("Resouce Not Found Exception");
    }

    public ResourceNotFoundException(String s) {
        super(s);
    }
}

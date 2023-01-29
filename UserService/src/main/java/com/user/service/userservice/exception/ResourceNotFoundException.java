package com.user.service.userservice.exception;

import org.hibernate.metamodel.relational.RuntimeRelationModelHelper;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("Resource Not Found Exception");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}

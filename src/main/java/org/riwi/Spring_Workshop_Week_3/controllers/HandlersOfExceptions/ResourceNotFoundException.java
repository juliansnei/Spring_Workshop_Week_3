package org.riwi.Spring_Workshop_Week_3.controllers.HandlersOfExceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}

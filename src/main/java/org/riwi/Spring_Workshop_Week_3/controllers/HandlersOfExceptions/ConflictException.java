package org.riwi.Spring_Workshop_Week_3.controllers.HandlersOfExceptions;

public class ConflictException  extends RuntimeException {
    public ConflictException(String message) {
        super(message);
    }
}

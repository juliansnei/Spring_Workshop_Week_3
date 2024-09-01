package org.riwi.Spring_Workshop_Week_3.controllers.HandlersOfExceptions;

import org.riwi.Spring_Workshop_Week_3.dtos.exception.ErrorSimple;
import org.riwi.Spring_Workshop_Week_3.dtos.exception.ErrorsListsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.MethodNotAllowedException;

import java.util.ArrayList;
import java.util.List;


@RestControllerAdvice
public class GeneralHandlerExceptions {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorSimple handleMethodArgumentNotValid(MethodArgumentNotValidException exception) {
        List<String> errors = new ArrayList<>();
        exception.getAllErrors().forEach(error -> errors.add(error.getDefaultMessage()));
        return ErrorsListsResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST.name())
                .errors(errors)
                .build();
    }

    @ExceptionHandler(MethodNotAllowedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ErrorSimple handleMethodNotAllowed(MethodNotAllowedException exception) {
        return ErrorsListsResponse.builder()
                .code(HttpStatus.METHOD_NOT_ALLOWED.value())
                .status(HttpStatus.METHOD_NOT_ALLOWED.name())
                .errors(List.of(exception.getMessage()))
                .build();
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorSimple handleNullPointerException(NullPointerException exception) {
        return ErrorsListsResponse.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.name())
                .errors(List.of("A null pointer exception occurred: " + exception.getMessage()))
                .build();
    }

    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorSimple handleConflict(ConflictException exception) {
        return ErrorsListsResponse.builder()
                .code(HttpStatus.CONFLICT.value())
                .status(HttpStatus.CONFLICT.name())
                .errors(List.of(exception.getMessage()))
                .build();
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorSimple handleResourceNotFound(ResourceNotFoundException exception) {
        return ErrorsListsResponse.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .status(HttpStatus.NOT_FOUND.name())
                .errors(List.of(exception.getMessage()))
                .build();
    }
}

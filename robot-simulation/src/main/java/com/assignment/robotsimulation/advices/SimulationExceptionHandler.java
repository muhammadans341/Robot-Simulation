package com.assignment.robotsimulation.advices;

import com.assignment.robotsimulation.domain.response.BaseResponse;
import com.assignment.robotsimulation.exceptions.ActionNotFoundException;
import com.assignment.robotsimulation.exceptions.InvalidGridPositionException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class SimulationExceptionHandler {
    @ExceptionHandler(value
            = {ActionNotFoundException.class})
    private ResponseEntity<Object> handleInvalidAction(
            ActionNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(
                new BaseResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value
            = {InvalidGridPositionException.class})
    private ResponseEntity<Object> handleInvalidPosition(
            InvalidGridPositionException ex, WebRequest request) {
        return new ResponseEntity<>(
                new BaseResponse(HttpStatus.NOT_ACCEPTABLE.value(), ex.getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value
            = {IllegalArgumentException.class})
    private ResponseEntity<Object> handleIllegalArgumentException(
            IllegalArgumentException ex, WebRequest request) {
        return new ResponseEntity<>(
                new BaseResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value
            = {Exception.class})
    private ResponseEntity<Object> handleUncaughtException(
            Exception ex, WebRequest request) {
        return new ResponseEntity<>(
                new BaseResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}

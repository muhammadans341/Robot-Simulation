package com.assignment.robotsimulation.advices;

import com.assignment.robotsimulation.domain.response.BaseResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class SimulationExceptionHandler {
    @ExceptionHandler(value
            = {IllegalArgumentException.class})
    private ResponseEntity<Object> handleIllegalArgumentException(
            IllegalArgumentException ex, WebRequest request) {
        return new ResponseEntity<>(
                new BaseResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}

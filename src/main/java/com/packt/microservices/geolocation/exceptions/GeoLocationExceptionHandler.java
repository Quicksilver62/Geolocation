package com.packt.microservices.geolocation.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeoLocationExceptionHandler {

    @ExceptionHandler(GeoLocationException.class)
    public ResponseEntity<Object> message (GeoLocationException c) {
        return new ResponseEntity<>(c.getMessage(), HttpStatus.BAD_REQUEST);
    }

}

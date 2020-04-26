package com.packt.microservices.geolocation.exceptions;

import org.springframework.http.HttpStatus;

public class GeoLocationException extends Exception {

    private final HttpStatus status;

    public GeoLocationException(Error error) {

        super(error.getCode());
        this.status = error.getStatus();

    }

    public HttpStatus getStatus() {
        return status;
    }

}

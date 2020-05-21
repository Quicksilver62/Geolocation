package com.packt.microservices.geolocation.exceptions;

public class GeoLocationException extends Exception {

    private final String description;

    public GeoLocationException(Error error) {

        super(error.getCode());
        this.description = error.getDescription();

    }

    public String getDescription() {
        return description;
    }
}

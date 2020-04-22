package com.packt.microservices.geolocation.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.UUID;

@Document
public class DTOGeolocation implements Serializable {

    private UUID userId;
    private double latitude;
    private double longitude;

    public DTOGeolocation(UUID userId, double latitude, double longitude) {
        this.userId = userId;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public UUID getUserId() {
        return userId;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}

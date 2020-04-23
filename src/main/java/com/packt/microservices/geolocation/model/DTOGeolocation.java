package com.packt.microservices.geolocation.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.UUID;

@Document
public class DTOGeolocation implements Serializable {

    private UUID userId;
    private UUID trackId;
    private double latitude;
    private double longitude;

    public DTOGeolocation(final UUID userId, final double latitude, final double longitude, final UUID trackId) {
        this.userId = userId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.trackId = trackId;
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

    public UUID getTrackId() { return trackId; }
}

package com.packt.microservices.geolocation.model;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

public class Coordinate implements Serializable {

    @Id
    private UUID coordId;
    private double latitude;
    private double longitude;
    private long timestamp;

    public Coordinate() {
        this.coordId = UUID.randomUUID();
        this.timestamp = Instant.now().toEpochMilli();
    }

    public UUID getCoordId() {
        return coordId;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public long getTimestamp() {
        return timestamp;
    }

}

package com.packt.microservices.geolocation.model;

import org.springframework.data.annotation.Id;

import java.time.Instant;
import java.util.UUID;

public class Coordinate {

    @Id
    private UUID coordinateId;
    private double latitude;
    private double longitude;
    private long timestamp;

    public Coordinate() {
        this.coordinateId = UUID.randomUUID();
        this.timestamp = Instant.now().toEpochMilli();
    }

    public UUID getCoordId() {
        return coordinateId;
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

    @Override
    public String toString() {
        return "Coordinate{" +
                "coordId=" + coordinateId +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", timestamp=" + timestamp +
                '}';
    }
}

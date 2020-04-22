package com.packt.microservices.geolocation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Document
public class GeoLocation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private UUID userId;
    private double latitude;
    private double longitude;
    private long timestamp;

    public GeoLocation() {
        this.timestamp = Instant.now().toEpochMilli();
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getId() {
        return id;
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

    public long getTimestamp() {
        return timestamp;
    }
}



package com.packt.microservices.geolocation.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.UUID;

@Document
public class DTOGeolocation implements Serializable {

    private String userId;
    private UUID trackId;
    private double latitude;
    private double longitude;

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUerId() {
        this.userId = null;
    }

    public void setTrackId(UUID trackId) {
        this.trackId = trackId;
    }

    public void setTrackId() {
        this.trackId = null;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getUserId() {
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

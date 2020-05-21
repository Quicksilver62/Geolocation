package com.packt.microservices.geolocation.dto;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class DTOGeolocation {

    private String userId;
    private UUID trackId;
    @NotNull
    private double latitude;
    @NotNull
    private double longitude;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UUID getTrackId() {
        return trackId;
    }

    public void setTrackId(UUID trackId) { this.trackId = trackId; }

    public double getLatitude() { return latitude; }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

}

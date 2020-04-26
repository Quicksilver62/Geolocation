package com.packt.microservices.geolocation.dto;

import com.packt.microservices.geolocation.exceptions.Error;
import com.packt.microservices.geolocation.exceptions.GeoLocationException;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class DTOGeolocation {

    private String userId;
    private UUID trackId;
    @NotNull
    private double latitude;
    @NotNull
    private double longitude;

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUerId() {
        this.userId = null;
    }

    public void setTrackId(String trackId) throws GeoLocationException {
        try {
            this.trackId = UUID.fromString(trackId);
        }
        catch (Exception e) {
            throw new GeoLocationException(Error.TYPE_MISMATCH);
        }

    }

    public void setTrackId() {
        this.trackId = null;
    }

    public void setLatitude(String latitude) throws GeoLocationException{
        try {
            this.latitude = Double.parseDouble(latitude);
        }
        catch (Exception e) {
            throw new GeoLocationException(Error.TYPE_MISMATCH);
        }
    }

    public void setLongitude(String longitude) throws GeoLocationException {
        try {
            this.longitude = Double.parseDouble(longitude);
        }
        catch (Exception e) {
            throw new GeoLocationException(Error.TYPE_MISMATCH);
        }
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

    public UUID getTrackId() {
        return trackId;
    }
}

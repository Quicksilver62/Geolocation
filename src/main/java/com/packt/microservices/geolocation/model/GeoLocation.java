package com.packt.microservices.geolocation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Document(collection = "geolocation")
public class GeoLocation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private UUID userId;
    private List<Track> trackList;

    public GeoLocation() {
        this.trackList = new ArrayList<>();
    }

    public GeoLocation(List<Track> trackList) {
        this.trackList = trackList;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
    }

    public List<Track> getTrackList() {
        return trackList;
    }

}



package com.packt.microservices.geolocation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "geolocation")
public class GeoLocation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String userId;
    private List<Track> trackList;

    public GeoLocation() {
        this.trackList = new ArrayList<>();
    }

    public GeoLocation(List<Track> trackList) {
        this.trackList = trackList;
    }

    public String getUserId() {
        return userId;
    }

    public List<Track> getTrackList() {
        return trackList;
    }

}



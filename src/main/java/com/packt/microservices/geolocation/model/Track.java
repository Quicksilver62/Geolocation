package com.packt.microservices.geolocation.model;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Track {

    @Id
    private UUID trackId;
    private List<Coordinate> coordinates;

    protected Track() {
        this.trackId = UUID.randomUUID();
        this.coordinates = new ArrayList<>();
    }

    public Track(List<Coordinate> coordinates) {
        this.trackId = UUID.randomUUID();
        this.coordinates = coordinates;
    }

    public UUID getTrackId() {
        return trackId;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    @Override
    public String toString() {
        return "Track{" +
                "trackId=" + trackId +
                '}';
    }

}

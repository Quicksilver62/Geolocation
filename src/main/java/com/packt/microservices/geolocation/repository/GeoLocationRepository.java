package com.packt.microservices.geolocation.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.packt.microservices.geolocation.model.GeoLocation;
import org.springframework.stereotype.Repository;

@Repository
public class GeoLocationRepository {

    private List<GeoLocation> geoLocations = new ArrayList<GeoLocation>();

    public void addGeoLocation(GeoLocation geoLocation) {
        geoLocations.add(geoLocation);
    }

    public List<GeoLocation> getGeoLocations() {
        return Collections.unmodifiableList(geoLocations);
    }
}

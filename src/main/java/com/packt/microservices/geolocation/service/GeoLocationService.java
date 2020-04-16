package com.packt.microservices.geolocation.service;

import com.packt.microservices.geolocation.model.GeoLocation;

import java.util.List;

public interface GeoLocationService {

    public GeoLocation create (GeoLocation geoLocation);
    public List<GeoLocation> findAll();

}

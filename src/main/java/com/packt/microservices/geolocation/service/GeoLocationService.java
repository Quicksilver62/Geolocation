package com.packt.microservices.geolocation.service;

import com.packt.microservices.geolocation.model.DTOGeolocation;
import com.packt.microservices.geolocation.model.GeoLocation;

import java.util.List;

public interface GeoLocationService {

    public GeoLocation create (DTOGeolocation dtoGeolocation);
    public List<GeoLocation> findAll();
    public void deleteAll();

}

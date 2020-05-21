package com.packt.microservices.geolocation.service;

import com.packt.microservices.geolocation.dto.DTOGeolocation;
import com.packt.microservices.geolocation.model.GeoLocation;
import com.packt.microservices.geolocation.model.Track;

import java.util.List;

public interface GeoLocationService {

    GeoLocation create (DTOGeolocation dtoGeolocation);
    GeoLocation update (DTOGeolocation dtoGeolocation, GeoLocation geoLocation);
    GeoLocation update (DTOGeolocation dtoGeolocation, GeoLocation geoLocation, Track track);
    List<GeoLocation> findAll();
    GeoLocation findByUserId(String userId);
    void deleteAll();

}

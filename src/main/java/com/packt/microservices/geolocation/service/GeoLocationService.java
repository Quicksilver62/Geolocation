package com.packt.microservices.geolocation.service;

import com.packt.microservices.geolocation.model.DTOGeolocation;
import com.packt.microservices.geolocation.model.GeoLocation;
import com.packt.microservices.geolocation.model.Track;

import java.util.List;

public interface GeoLocationService {

    public GeoLocation create (DTOGeolocation dtoGeolocation);
    public GeoLocation update (DTOGeolocation dtoGeolocation, GeoLocation geoLocation);
    public GeoLocation update (DTOGeolocation dtoGeolocation, GeoLocation geoLocation, Track track);
    public List<GeoLocation> findAll();
    public GeoLocation findByUserId(String userId);
    public void deleteAll();

}

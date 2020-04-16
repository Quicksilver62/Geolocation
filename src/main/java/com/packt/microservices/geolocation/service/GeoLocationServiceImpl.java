package com.packt.microservices.geolocation.service;

import com.packt.microservices.geolocation.repository.GeoLocationRepository;
import com.packt.microservices.geolocation.model.GeoLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeoLocationServiceImpl implements GeoLocationService {

    @Autowired
    private GeoLocationRepository repository;

    @Override
    public GeoLocation create(GeoLocation geoLocation) {
        repository.addGeoLocation(geoLocation);
        return geoLocation;
    }

    @Override
    public List<GeoLocation> findAll() {
        return repository.getGeoLocations();
    }
}

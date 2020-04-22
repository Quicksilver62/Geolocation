package com.packt.microservices.geolocation.service;

import com.packt.microservices.geolocation.model.DTOGeolocation;
import com.packt.microservices.geolocation.repository.GeoLocationRepository;
import com.packt.microservices.geolocation.model.GeoLocation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GeoLocationServiceImpl implements GeoLocationService {

    @Autowired
    private GeoLocationRepository repository;

    @Override
    public GeoLocation create(DTOGeolocation dtoGeolocation) {

        GeoLocation geoLocation = new GeoLocation();

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dtoGeolocation, geoLocation);

        repository.save(geoLocation);

        return geoLocation;
    }

    @Override
    public List<GeoLocation> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

}

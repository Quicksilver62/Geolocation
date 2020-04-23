package com.packt.microservices.geolocation.service;

import com.packt.microservices.geolocation.model.Coordinate;
import com.packt.microservices.geolocation.model.DTOGeolocation;
import com.packt.microservices.geolocation.model.Track;
import com.packt.microservices.geolocation.repository.GeoLocationRepository;
import com.packt.microservices.geolocation.model.GeoLocation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class GeoLocationServiceImpl implements GeoLocationService {

    @Autowired
    private GeoLocationRepository repository;

    @Override
    public GeoLocation create(DTOGeolocation dtoGeolocation) {

        Coordinate coordinate = new Coordinate();

        Track track = new Track(Arrays.asList(coordinate));

        GeoLocation geoLocation = new GeoLocation(Arrays.asList(track));

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dtoGeolocation, coordinate);
        modelMapper.map(dtoGeolocation, geoLocation);

        repository.save(geoLocation);

        return geoLocation;
    }

    @Override
    public List<GeoLocation> findAll() {
        return repository.findAll();
    }

    @Override
    public List<GeoLocation> findByUserId(UUID userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

}

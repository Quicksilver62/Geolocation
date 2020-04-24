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

@Service
public class GeoLocationServiceImpl implements GeoLocationService {

    @Autowired
    private GeoLocationRepository repository;

    @Override
    public GeoLocation create(final DTOGeolocation dtoGeolocation) {

        Coordinate coordinate = mapper(dtoGeolocation);
        GeoLocation geoLocation = new GeoLocation(Arrays.asList(new Track(Arrays.asList(coordinate))));
        repository.save(geoLocation);
        return geoLocation;

    }

    @Override
    public GeoLocation update(final DTOGeolocation dtoGeolocation, final GeoLocation geoLocation) {

        Coordinate coordinate = mapper(dtoGeolocation);
        Track track = new Track(Arrays.asList(coordinate));
        geoLocation.getTrackList().add(track);
        repository.save(geoLocation);
        return geoLocation;

    }

    @Override
    public GeoLocation update(final DTOGeolocation dtoGeolocation, final GeoLocation geoLocation, final Track track) {

        Coordinate coordinate = mapper(dtoGeolocation);
        track.getCoordinates().add(coordinate);
        repository.save(geoLocation);
        return geoLocation;

    }

    private GeoLocation setNewTrack(final GeoLocation geoLocation, final Coordinate coordinate) {
        Track track = new Track(Arrays.asList(coordinate));
        geoLocation.getTrackList().add(track);
        return geoLocation;
    }


    @Override
    public List<GeoLocation> findAll() {
        return repository.findAll();
    }

    @Override
    public GeoLocation findByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    private Coordinate mapper(final DTOGeolocation dtoGeolocation) {
        Coordinate coordinate = new Coordinate();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dtoGeolocation, coordinate);
        return coordinate;
    }

}

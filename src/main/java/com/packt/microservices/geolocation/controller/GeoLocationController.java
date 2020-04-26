package com.packt.microservices.geolocation.controller;

import com.packt.microservices.geolocation.exceptions.Error;
import com.packt.microservices.geolocation.exceptions.GeoLocationException;
import com.packt.microservices.geolocation.dto.DTOGeolocation;
import com.packt.microservices.geolocation.model.Track;
import com.packt.microservices.geolocation.service.GeoLocationService;
import com.packt.microservices.geolocation.model.GeoLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/geolocation")
public class GeoLocationController {

    private GeoLocation geoLocation;

    @Autowired
    private GeoLocationService service;

    @ResponseStatus(code = HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public GeoLocation create(@Validated @RequestBody DTOGeolocation dtoGeolocation) throws GeoLocationException {

        try {
            geoLocation = service.findByUserId(dtoGeolocation.getUserId());
        }
        catch (Exception e) {
            throw new GeoLocationException(Error.INTERNAL_ERROR);
        }

        if (dtoGeolocation.getUserId() == null) {
            return service.create(dtoGeolocation);
        }

        else if (geoLocation == null) {
            throw new GeoLocationException(Error.USER_NOT_FOUND);
        }

        if (dtoGeolocation.getTrackId() == null) {
            return service.update(dtoGeolocation, geoLocation);
        }

        else {
            Track track = geoLocation.getTrackList().stream()
                    .filter(e -> dtoGeolocation.getTrackId().equals(e.getTrackId()))
                    .findAny()
                    .orElseThrow(() -> new GeoLocationException(Error.TRACK_NOT_FOUND));
            return service.update(dtoGeolocation, geoLocation, track);
        }

    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GeoLocation> findAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public GeoLocation findById(@PathVariable("userId") String userId) {
        return service.findByUserId(userId);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAll() {
        service.deleteAll();
    }

}

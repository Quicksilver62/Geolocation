package com.packt.microservices.geolocation.controller;

import com.packt.microservices.geolocation.exceptions.GeoLocationException;
import com.packt.microservices.geolocation.model.DTOGeolocation;
import com.packt.microservices.geolocation.model.Track;
import com.packt.microservices.geolocation.service.GeoLocationService;
import com.packt.microservices.geolocation.model.GeoLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/geolocation")
public class GeoLocationController {

    private GeoLocation geoLocation;

    @Autowired
    private GeoLocationService service;

    @ResponseStatus(code = HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public GeoLocation create(@Valid @RequestBody DTOGeolocation dtoGeolocation) throws GeoLocationException {

        try {
            geoLocation = service.findByUserId(dtoGeolocation.getUserId());
        }
        catch (Exception e) {}

        if (dtoGeolocation.getUserId() == null) {
            return service.create(dtoGeolocation);
        }

        else if (geoLocation == null) {
            throw new GeoLocationException("USER_NOT_FOOUND");
        }

        if (dtoGeolocation.getTrackId() == null) {
            return service.update(dtoGeolocation, geoLocation);
        }

        else {
            Track track = geoLocation.getTrackList().stream()
                    .filter(e -> dtoGeolocation.getTrackId().equals(e.getTrackId()))
                    .findAny()
                    .orElse(null);
            if(track == null) {
                throw new GeoLocationException("TRACK_NOT_FOUND");
            }
            return service.update(dtoGeolocation, geoLocation, track);
        }

    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<GeoLocation> findAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = "application/json")
    public GeoLocation findById(@PathVariable("userId") String userId) {
        return service.findByUserId(userId);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @RequestMapping(method = RequestMethod.DELETE, produces = "application/json")
    public void deleteAll() {
        service.deleteAll();
    }

}

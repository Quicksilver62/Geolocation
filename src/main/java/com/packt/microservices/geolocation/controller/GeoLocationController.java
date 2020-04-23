package com.packt.microservices.geolocation.controller;

import com.packt.microservices.geolocation.model.DTOGeolocation;
import com.packt.microservices.geolocation.service.GeoLocationService;
import com.packt.microservices.geolocation.model.GeoLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/geolocation")
public class GeoLocationController {

    @Autowired
    private GeoLocationService service;

    @ResponseStatus(code = HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public GeoLocation create(@Valid @RequestBody DTOGeolocation dtoGeolocation) {
        return service.create(dtoGeolocation);
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<GeoLocation> findAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = "application/json")
    public List<GeoLocation> findById(@PathVariable("userId") UUID userId) {return service.findByUserId(userId);}

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @RequestMapping(method = RequestMethod.DELETE, produces = "application/json")
    public void deleteAll() { service.deleteAll(); }

}

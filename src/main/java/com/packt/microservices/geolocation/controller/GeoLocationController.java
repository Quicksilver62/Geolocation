package com.packt.microservices.geolocation.controller;

import com.packt.microservices.geolocation.service.GeoLocationService;
import com.packt.microservices.geolocation.model.GeoLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/geolocation")
public class GeoLocationController {

    @Autowired
    private GeoLocationService service;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public GeoLocation create(@RequestBody GeoLocation geoLocation) {
        return service.create(geoLocation);
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<GeoLocation> findAll() {
        return service.findAll();
    }

}

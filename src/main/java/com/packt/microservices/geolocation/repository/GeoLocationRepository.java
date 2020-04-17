package com.packt.microservices.geolocation.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import com.packt.microservices.geolocation.model.GeoLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeoLocationRepository extends MongoRepository<GeoLocation, Double> {

//    private List<GeoLocation> geoLocations = new ArrayList<GeoLocation>();
//
//    public void addGeoLocation(GeoLocation geoLocation) {
//        geoLocations.add(geoLocation);
//    }
//
//    public List<GeoLocation> getGeoLocations() {
//        return Collections.unmodifiableList(geoLocations);
//    }

//    public List<GeoLocation> getGeoLocations() {
//        return mongoTemplate.findAll(GeoLocation.class);

    List<GeoLocation> findByUserId(UUID userId);

}

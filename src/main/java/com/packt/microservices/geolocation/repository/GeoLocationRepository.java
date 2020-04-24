package com.packt.microservices.geolocation.repository;

import java.util.List;
import java.util.UUID;

import com.packt.microservices.geolocation.model.GeoLocation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeoLocationRepository extends MongoRepository<GeoLocation, String> {

    public GeoLocation findByUserId(String userId);

}

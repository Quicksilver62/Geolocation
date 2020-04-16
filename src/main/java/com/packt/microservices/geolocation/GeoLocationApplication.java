package com.packt.microservices.geolocation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.packt"})
public class GeoLocationApplication {

    public static void main(String[] args) throws Exception {

        SpringApplication.run(GeoLocationApplication.class, args);

    }

}

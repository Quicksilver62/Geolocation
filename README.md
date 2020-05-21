# Geolocation

This is REST API example geolocation tracking application.
The entire application stores data by using Spring Data MongoDB.
Communication is done over HTTP. Both request and response are formatted as JSON, and the content type of both is application/json.

## Run
mvn clean install
java -jar ./target/geolocation-0.0.1-SNAPSHOT.jar

## Geolocation requests

## Get list of geolocations
http://localhost:8181/geolocation 

## Get user's geolocation
http://localhost:8181/geolocation/{userId} 

## Create 
Geolocation requests are sent using POST to the following URL: http://localhost:8181/geolocation 

## Create new user and track
request body:
{
  "latitude": 9.568012, 
  "longitude": 77.962444
}

## Add new track to existing user
request body:
{
  "userId": "5ec67af5689f2d02025bca64", 
  "latitude": 55.8494987, 
  "longitude": 37.683994
}


## Add new geolocation to existing track
{
  "userId": "5ec67af5689f2d02025bca64",
  "trackId": "9d7cd1cd-1fb1-48b7-a700-7bfa1f093338", 
  "latitude": -35.307473, 
  "longitude": 149.190486
}

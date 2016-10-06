package com.jzheadley.RideShareU.Controllers;

import com.jzheadley.RideShareU.models.Trip;
import com.jzheadley.RideShareU.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@ComponentScan
public class TripController {

    @Autowired
    TripRepository tripRepository;

    // Retrieve All Trips

    /**
     * maps the url http://<server address>/trip/ to this method.
     *
     * @return ResponseEntity<List<Trip>>> This sets the response of the server to be an entity containing the list of trips
     * In other words, this creates the json you see.  The backend framework automatically
     * converts the list of object into a json array of the trip objects as json objects.
     */
    @RequestMapping(value = "/trip/", method = RequestMethod.GET)
    public ResponseEntity<List<Trip>> listAllTrips() {
        List<Trip> trips = (List<Trip>) tripRepository.findAll();
        if (trips.isEmpty()) {
            return new ResponseEntity<List<Trip>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Trip>>(trips, HttpStatus.OK);
    }

    // Get Trip by id
    @RequestMapping(value = "/trip/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Trip listTripById(@PathVariable int id) {
        return tripRepository.findOne(id);
    }

    // Create Trip
    @RequestMapping(value = "/trip/create/", method = RequestMethod.POST)
    public ResponseEntity<Void> createTrip(@RequestBody Trip trip, UriComponentsBuilder uriComponentsBuilder) {
        System.out.println("Creating Seat " + trip.toString() + " ");
        tripRepository.save(trip);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/trip/{id}").buildAndExpand(trip.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    // UpdateTrip

    // DeleteTrip
    @RequestMapping(value = "/trip/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteTripById(@PathVariable int id) {
        Trip trip = tripRepository.findOne(id);
        HttpHeaders headers = new HttpHeaders();
        if (trip == null) {
            return new ResponseEntity<Void>(headers, HttpStatus.BAD_REQUEST);
        }
        System.out.println("Deleting trip " + trip.toString() + " ");
        tripRepository.delete(id);
        return new ResponseEntity<Void>(headers, HttpStatus.OK);
    }

}

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
    @RequestMapping(value = "/trip/", method = RequestMethod.GET)
    public ResponseEntity<List<Trip>> listAllTrips() {
        List<Trip> users = (List<Trip>) tripRepository.findAll();
        if (users.isEmpty()) {
            return new ResponseEntity<List<Trip>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Trip>>(users, HttpStatus.OK);
    }

    // Get Trip by id
    @RequestMapping(value = "/trip/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Trip listTripById(@PathVariable int id) {
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

}

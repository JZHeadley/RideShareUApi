package com.jzheadley.RideShareU.Controllers;

import com.jzheadley.RideShareU.models.TripSeat;
import com.jzheadley.RideShareU.repositories.TripSeatRepository;
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
public class TripSeatController {

    @Autowired
    TripSeatRepository tripSeatRepository;

    // Retrieve All TripSeats
    @RequestMapping(value = "/tripseat/", method = RequestMethod.GET)
    public ResponseEntity<List<TripSeat>> listAllTripSeats() {
        List<TripSeat> users = (List<TripSeat>) tripSeatRepository.findAll();
        if (users.isEmpty()) {
            return new ResponseEntity<List<TripSeat>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<TripSeat>>(users, HttpStatus.OK);
    }

    // Retrieve one tripseat by id
    @RequestMapping(value = "/tripseat/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    TripSeat listTripSeatById(@PathVariable int id) {
        return tripSeatRepository.findOne(id);
    }

    // Create TripSeat
    @RequestMapping(value = "/tripseat/create/", method = RequestMethod.POST)
    public ResponseEntity<Void> createTripSeat(@RequestBody TripSeat tripSeat, UriComponentsBuilder uriComponentsBuilder) {
        System.out.println("Creating Seat " + tripSeat.toString() + " ");
        tripSeatRepository.save(tripSeat);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/tripSeat/{id}").buildAndExpand(tripSeat.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    // UpdateTripSeat

    // DeleteTripSeat
    @RequestMapping(value = "/tripseat/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteTripSeatById(@PathVariable int id) {
        TripSeat tripSeat = tripSeatRepository.findOne(id);
        HttpHeaders headers = new HttpHeaders();
        if (tripSeat == null) {
            return new ResponseEntity<Void>(headers, HttpStatus.BAD_REQUEST);
        }
        System.out.println("Deleting tripSeat " + tripSeat.toString() + " ");
        tripSeatRepository.delete(id);
        return new ResponseEntity<Void>(headers, HttpStatus.OK);
    }
}

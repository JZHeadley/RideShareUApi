package com.jzheadley.RideShareU.Controllers;

import com.jzheadley.RideShareU.models.TripSeat;
import com.jzheadley.RideShareU.repositories.TripSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ComponentScan
public class TripSeatController {

    @Autowired
    TripSeatRepository tripSeatRepository;

    // Retrieve All Users
    @RequestMapping(value = "/tripseat/", method = RequestMethod.GET)
    public ResponseEntity<List<TripSeat>> listAllTripSeats() {
        List<TripSeat> users = (List<TripSeat>) tripSeatRepository.findAll();
        if (users.isEmpty()) {
            return new ResponseEntity<List<TripSeat>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<TripSeat>>(users, HttpStatus.OK);
    }


    @RequestMapping(value = "/tripseat/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    TripSeat listTripSeatById(@PathVariable int id) {
        return tripSeatRepository.findOne(id);
    }


}

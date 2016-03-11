package com.jzheadley.RideShareU.Controllers;

import com.jzheadley.RideShareU.models.Seat;
import com.jzheadley.RideShareU.repositories.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ComponentScan
public class SeatController {

    @Autowired
    SeatRepository seatRepository;

    // Retrieve All Seats
    @RequestMapping(value = "/seat/", method = RequestMethod.GET)
    public ResponseEntity<List<Seat>> listAllSeats() {
        List<Seat> users = (List<Seat>) seatRepository.findAll();
        if (users.isEmpty()) {
            return new ResponseEntity<List<Seat>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Seat>>(users, HttpStatus.OK);
    }

    // Retrieve one user by id
    @RequestMapping(value = "/seat/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Seat listSeatById(@PathVariable int id) {
        return seatRepository.findOne(id);
    }


}

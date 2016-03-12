package com.jzheadley.RideShareU.Controllers;

import com.jzheadley.RideShareU.models.Vehicle;
import com.jzheadley.RideShareU.repositories.VehicleRepository;
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
public class VehicleController {

    @Autowired
    VehicleRepository vehicleRepository;

    // Retrieve All Users
    @RequestMapping(value = "/vehicle/", method = RequestMethod.GET)
    public ResponseEntity<List<Vehicle>> listAllVehicles() {
        List<Vehicle> users = (List<Vehicle>) vehicleRepository.findAll();
        if (users.isEmpty()) {
            return new ResponseEntity<List<Vehicle>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Vehicle>>(users, HttpStatus.OK);
    }


    @RequestMapping(value = "/vehicle/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Vehicle listVehicleById(@PathVariable int id) {
        return vehicleRepository.findOne(id);
    }

    // Create Trip
    @RequestMapping(value = "/vehicle/create/", method = RequestMethod.POST)
    public ResponseEntity<Void> createVehicle(@RequestBody Vehicle vehicle, UriComponentsBuilder uriComponentsBuilder) {
        System.out.println("Creating Seat " + vehicle.toString() + " ");
        vehicleRepository.save(vehicle);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/vehicle/{id}").buildAndExpand(vehicle.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    // UpdateVehicle

    // DeleteVehicle
    @RequestMapping(value = "/vehicle/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteVehicleById(@PathVariable int id) {
        Vehicle vehicle = vehicleRepository.findOne(id);
        HttpHeaders headers = new HttpHeaders();
        if (vehicle == null) {
            return new ResponseEntity<Void>(headers, HttpStatus.BAD_REQUEST);
        }
        System.out.println("Deleting vehicle " + vehicle.toString() + " ");
        vehicleRepository.delete(id);
        return new ResponseEntity<Void>(headers, HttpStatus.OK);
    }
}

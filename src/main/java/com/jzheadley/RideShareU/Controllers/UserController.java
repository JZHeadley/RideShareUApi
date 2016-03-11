package com.jzheadley.RideShareU.Controllers;

import com.jzheadley.RideShareU.models.User;
import com.jzheadley.RideShareU.repositories.UserRepository;
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
public class UserController {

    @Autowired
    UserRepository userRepository;

    // Retrieve All Users
    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = (List<User>) userRepository.findAll();
        if (users.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }


    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    User listUserById(@PathVariable int id) {
        return userRepository.findOne(id);
    }

    // Create User
    @RequestMapping(value = "/user/create/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder uriComponentsBuilder) {
        System.out.println("Creating Seat " + user.toString() + " ");
        userRepository.save(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}

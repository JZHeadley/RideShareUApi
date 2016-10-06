package com.jzheadley.RideShareU.repositories;

import com.jzheadley.RideShareU.models.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zephy on 3/10/2016.
 */
@Repository
public interface TripRepository extends CrudRepository<Trip, Integer> {
    List<Trip> findBySource(String source);

    List<Trip> findByDestination(String destination);

    List<Trip> findByDepartureTime(String departureTime);

}

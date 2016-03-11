package com.jzheadley.RideShareU.repositories;

import com.jzheadley.RideShareU.models.TripSeat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by zephy on 3/10/2016.
 */
@Repository
public interface TripSeatRepository extends CrudRepository<TripSeat, Integer> {
}

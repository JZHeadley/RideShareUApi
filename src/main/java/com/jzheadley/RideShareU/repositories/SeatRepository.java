package com.jzheadley.RideShareU.repositories;

import com.jzheadley.RideShareU.models.Seat;
import com.jzheadley.RideShareU.models.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zephy on 3/10/2016.
 */
@Repository
public interface SeatRepository extends CrudRepository<Seat, Integer> {

    List<Seat> findByVehicle(Vehicle vehicle);

    List<Seat> findByValueFactor(double valueFactor);

}

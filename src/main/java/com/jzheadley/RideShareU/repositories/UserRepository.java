package com.jzheadley.RideShareU.repositories;

import com.jzheadley.RideShareU.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by zephy on 3/10/2016.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}

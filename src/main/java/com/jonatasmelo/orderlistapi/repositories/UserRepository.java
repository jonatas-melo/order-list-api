package com.jonatasmelo.orderlistapi.repositories;

import com.jonatasmelo.orderlistapi.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUserNameAndPassword(String userName, String password);
    Optional<User> findByToken(String token);
}

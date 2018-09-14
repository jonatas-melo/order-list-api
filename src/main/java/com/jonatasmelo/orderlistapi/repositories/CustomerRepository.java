package com.jonatasmelo.orderlistapi.repositories;

import com.jonatasmelo.orderlistapi.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}

package com.jonatasmelo.orderlistapi.repositories;

import com.jonatasmelo.orderlistapi.entities.Customer;
import com.jonatasmelo.orderlistapi.entities.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findAllByCustomerOrderByDate(Customer customer);
}

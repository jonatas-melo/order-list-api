package com.jonatasmelo.orderlistapi.services;

import com.jonatasmelo.orderlistapi.entities.Order;

import java.util.List;

public interface OrderService {
    Iterable<Order> listAll();
    List<Order> listAllByCustomer(Long id);
}

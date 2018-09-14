package com.jonatasmelo.orderlistapi.services;

import com.jonatasmelo.orderlistapi.entities.Customer;

public interface CustomerService {
    Iterable<Customer> listAll();
}

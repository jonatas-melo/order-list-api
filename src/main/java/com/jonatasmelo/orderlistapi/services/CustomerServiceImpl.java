package com.jonatasmelo.orderlistapi.services;

import com.jonatasmelo.orderlistapi.entities.Customer;
import com.jonatasmelo.orderlistapi.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Iterable<Customer> listAll() {
        return customerRepository.findAll();
    }
}

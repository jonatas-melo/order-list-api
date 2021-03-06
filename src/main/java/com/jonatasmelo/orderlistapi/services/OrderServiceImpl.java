package com.jonatasmelo.orderlistapi.services;

import com.jonatasmelo.orderlistapi.entities.Customer;
import com.jonatasmelo.orderlistapi.entities.Order;
import com.jonatasmelo.orderlistapi.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Iterable<Order> listAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> listAllByCustomer(Long id) {
        return orderRepository.findAllByCustomerOrderByDate(new Customer(id));
    }
}

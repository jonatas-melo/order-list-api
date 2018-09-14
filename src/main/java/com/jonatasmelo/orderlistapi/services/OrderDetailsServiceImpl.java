package com.jonatasmelo.orderlistapi.services;

import com.jonatasmelo.orderlistapi.entities.Order;
import com.jonatasmelo.orderlistapi.entities.OrderDetails;
import com.jonatasmelo.orderlistapi.repositories.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Override
    public List<OrderDetails> listAll(Order order) {
        List<OrderDetails> orderDetailsList = new ArrayList<>();
        if(order != null && order.getNumber() != null) {
            orderDetailsList = orderDetailsRepository.findAllByOrderNumber(order.getNumber());
        }

        return orderDetailsList;
    }
}

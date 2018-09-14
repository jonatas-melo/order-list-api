package com.jonatasmelo.orderlistapi.services;

import com.jonatasmelo.orderlistapi.entities.Order;
import com.jonatasmelo.orderlistapi.entities.OrderDetails;

import java.util.List;

public interface OrderDetailsService {
    List<OrderDetails> listAll(Order order);
}

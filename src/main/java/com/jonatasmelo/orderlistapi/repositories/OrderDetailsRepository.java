package com.jonatasmelo.orderlistapi.repositories;

import com.jonatasmelo.orderlistapi.entities.OrderDetails;
import com.jonatasmelo.orderlistapi.entities.OrderDetailsId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderDetailsRepository extends CrudRepository<OrderDetails, OrderDetailsId> {
    List<OrderDetails> findAllByOrderNumber(Long orderNumber);
}

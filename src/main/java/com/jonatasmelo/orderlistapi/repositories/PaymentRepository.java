package com.jonatasmelo.orderlistapi.repositories;

import com.jonatasmelo.orderlistapi.entities.Payment;
import com.jonatasmelo.orderlistapi.entities.PaymentId;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, PaymentId> {
}

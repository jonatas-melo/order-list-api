package com.jonatasmelo.orderlistapi.controllers;

import com.jonatasmelo.orderlistapi.entities.Customer;
import com.jonatasmelo.orderlistapi.entities.Order;
import com.jonatasmelo.orderlistapi.entities.OrderDetails;
import com.jonatasmelo.orderlistapi.response.CustomerResponse;
import com.jonatasmelo.orderlistapi.response.OrderDetailResponse;
import com.jonatasmelo.orderlistapi.response.OrderResponse;
import com.jonatasmelo.orderlistapi.services.CustomerService;
import com.jonatasmelo.orderlistapi.services.OrderDetailsService;
import com.jonatasmelo.orderlistapi.services.OrderService;
import com.jonatasmelo.orderlistapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {
    @Autowired
    private UserService userService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailsService orderDetailsService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<CustomerResponse>> list(@RequestHeader(name = "access_token") String accessToken) {
        if (userService.isValidToken(accessToken)) {
            Iterable<Customer> itCustomers = customerService.listAll();
            List<CustomerResponse> customerList = new ArrayList<>();
            itCustomers.forEach(customer -> customerList.add(CustomerResponse.parse(customer)));
            return ResponseEntity.ok(customerList);
        }

        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    @RequestMapping(value = "/{id}/orders", method = RequestMethod.GET)
    public ResponseEntity<List<OrderResponse>> listOrders(@RequestHeader(name = "access_token") String accessToken,
                                                          @PathVariable("id") Long id) {
        if (userService.isValidToken(accessToken) && id != null) {
            List<Order> orders = orderService.listAllByCustomer(id);
            List<OrderResponse> orderResponseList = new ArrayList<>();

            if (orders != null) {
                orders.forEach(order -> {
                    OrderResponse orderResponse = OrderResponse.parse(order);
                    List<OrderDetails> orderDetailsList = orderDetailsService.listAll(order);
                    if (orderDetailsList != null) {
                        orderDetailsList.forEach(orderDetails -> orderResponse.getDetailList().add(OrderDetailResponse.parse(orderDetails)));
                    }

                    orderResponseList.add(orderResponse);
                });
            }

            return ResponseEntity.ok(orderResponseList);
        }

        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
}

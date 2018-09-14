package com.jonatasmelo.orderlistapi.controllers;

import com.jonatasmelo.orderlistapi.entities.Order;
import com.jonatasmelo.orderlistapi.services.OrderService;
import com.jonatasmelo.orderlistapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/orders")
public class OrdersController {

    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Iterable<Order>> list(@RequestHeader(name = "access_token") String accessToken) {
        if (userService.isValidToken(accessToken)) {
            return ResponseEntity.ok(orderService.listAll());
        }

        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

}

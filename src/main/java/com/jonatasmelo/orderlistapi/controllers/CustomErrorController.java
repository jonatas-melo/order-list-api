package com.jonatasmelo.orderlistapi.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomErrorController implements ErrorController {

    @RequestMapping(value = "/error")
    public String error() {
        return "Just a error page";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}

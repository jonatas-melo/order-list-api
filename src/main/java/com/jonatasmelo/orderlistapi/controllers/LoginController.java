package com.jonatasmelo.orderlistapi.controllers;

import com.jonatasmelo.orderlistapi.entities.User;
import com.jonatasmelo.orderlistapi.request.LoginRequest;
import com.jonatasmelo.orderlistapi.response.UserResponse;
import com.jonatasmelo.orderlistapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/login")
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<UserResponse> login(@RequestBody LoginRequest loginRequest) {
        if (loginRequest != null
                && !StringUtils.isEmpty(loginRequest.getUserName())
                && !StringUtils.isEmpty(loginRequest.getPassword())) {

            User userWithToken = userService.getUserWithToken(loginRequest.getUserName(), loginRequest.getPassword());

            UserResponse response = null;
            if (userWithToken != null) {
                response = new UserResponse(userWithToken.getUserName(), userWithToken.getToken(), userWithToken.getTokenExpirationDate());
            }
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}

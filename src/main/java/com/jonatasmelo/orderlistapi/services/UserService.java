package com.jonatasmelo.orderlistapi.services;

import com.jonatasmelo.orderlistapi.entities.User;

public interface UserService {
    User getUserWithToken(String userName, String password);
    boolean isValidToken(String token);
}

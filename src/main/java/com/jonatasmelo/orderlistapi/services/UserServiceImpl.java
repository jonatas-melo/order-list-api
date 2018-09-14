package com.jonatasmelo.orderlistapi.services;

import com.jonatasmelo.orderlistapi.entities.User;
import com.jonatasmelo.orderlistapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserWithToken(String userName, String password) {
        Optional<User> optUser = userRepository.findByUserNameAndPassword(userName, password);

        if (optUser.isPresent()) {
            String token = UUID.randomUUID().toString();
            User user = optUser.get();
            user.setToken(token);
            user.setTokenExpirationDate(LocalDateTime.now().plusMinutes(30));

            userRepository.save(user);
            return user;
        }

        return null;
    }

    @Override
    public boolean isValidToken(String accessToken) {
        if (!StringUtils.isEmpty(accessToken)) {
            Optional<User> optUser = userRepository.findByToken(accessToken);
            if (optUser.isPresent()) {
                User user = optUser.get();

                return (LocalDateTime.now().isBefore(user.getTokenExpirationDate()));
            }
        }

        return false;
    }
}

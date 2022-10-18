package com.smallAPI.smallAPI.h2.services;

import com.smallAPI.smallAPI.h2.models.User;
import com.smallAPI.smallAPI.h2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class UserQueryService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserById(Long userId) {
        return  userRepository.findById(userId);
    }
    public User createUser(Map<String, String> userData) {
        User newUser = User.builder().firstName(userData.get("firstName")).lastName(userData.get("lastName")).build();
        userRepository.save(newUser);
        return newUser;
    }
}

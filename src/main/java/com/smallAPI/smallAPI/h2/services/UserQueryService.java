package com.smallAPI.smallAPI.h2.services;

import com.smallAPI.smallAPI.h2.models.User;
import com.smallAPI.smallAPI.h2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserQueryService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserById(Long userId) {
        System.out.println(userId);
        return  userRepository.findById(userId);
    }
}

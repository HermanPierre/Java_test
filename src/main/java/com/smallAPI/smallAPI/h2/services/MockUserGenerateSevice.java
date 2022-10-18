package com.smallAPI.smallAPI.h2.services;

import com.smallAPI.smallAPI.h2.models.User;
import com.smallAPI.smallAPI.h2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MockUserGenerateSevice {
    @Autowired
    private UserRepository userRepository;

    @Autowired

    public void generateAccounts() {
        User account1=  User.builder()
                .firstName("Pierre")
                .lastName("H")
                .build();
        userRepository.save(account1);

        User account2=  User.builder()
                .firstName("Jean")
                .lastName("Dupont")
                .build();

        userRepository.save(account2);
    }
}

package com.smallAPI.smallAPI.h2.repositories;

import com.smallAPI.smallAPI.h2.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

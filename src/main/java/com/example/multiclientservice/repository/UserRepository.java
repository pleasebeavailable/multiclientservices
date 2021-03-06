package com.example.multiclientservice.repository;

import com.example.multiclientservice.repository.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    Boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}

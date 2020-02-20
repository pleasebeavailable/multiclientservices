package com.example.multiclientservice.repository;

import com.example.multiclientservice.repository.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String role);
}

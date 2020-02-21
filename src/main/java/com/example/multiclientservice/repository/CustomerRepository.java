package com.example.multiclientservice.repository;

import com.example.multiclientservice.repository.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Purchase, Long> {
}

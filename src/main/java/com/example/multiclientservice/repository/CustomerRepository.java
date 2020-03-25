package com.example.multiclientservice.repository;

import com.example.multiclientservice.repository.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Purchase, Long> {

    List<Purchase> findAllByUserId(long user_id);
}

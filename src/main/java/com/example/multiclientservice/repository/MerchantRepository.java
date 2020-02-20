package com.example.multiclientservice.repository;

import com.example.multiclientservice.repository.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Job, Long> {
    Job findByName(String name);
}

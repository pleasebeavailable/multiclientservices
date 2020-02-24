package com.example.multiclientservice.repository;

import com.example.multiclientservice.repository.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MerchantRepository extends JpaRepository<Job, Long> {

    @Query(value = "SELECT j FROM jobs j WHERE j.user_id = ?1",
    nativeQuery = true)
    List<Job> findJobsByMerchantId(Long id);

}

package com.example.multiclientservice.service;

import com.example.multiclientservice.repository.model.Job;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;

public interface IMerchantService {

    Job getJob(long id) throws NotFoundException;

    Job addJob(Job job);

    ResponseEntity<Object> deleteJob(long id) throws NotFoundException;

    Job editJob(long id, Job job) throws NotFoundException;
}

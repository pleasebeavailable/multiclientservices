package com.example.multiclientservice.service;

import com.example.multiclientservice.repository.model.Job;
import com.example.multiclientservice.web.dto.JobDto;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IMerchantService {

    List<JobDto> getAllJobs();

    JobDto getJob(long id) throws NotFoundException;

    JobDto addJob(Job job);

    List<JobDto> addJobs(List<Job> jobs);

    ResponseEntity<Object> deleteJob(long id) throws NotFoundException;

    JobDto editJob(long id, Job job) throws NotFoundException;
}

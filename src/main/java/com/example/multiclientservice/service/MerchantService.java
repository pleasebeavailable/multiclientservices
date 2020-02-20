package com.example.multiclientservice.service;

import com.example.multiclientservice.repository.MerchantRepository;
import com.example.multiclientservice.repository.model.Job;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantService implements IMerchantService {

    @Autowired
    private MerchantRepository merchantRepository;

    @Override
    public List<Job> getAllJobs() {
        return merchantRepository.findAll();
    }

    @Override
    public Job getJob(long id) throws NotFoundException {
        return merchantRepository.findById(id).orElseThrow(() -> new NotFoundException("Job with id: " + id + " was not found!"));
    }
    @Override
    public Job addJob(Job job) { //JobDto
        return merchantRepository.save(job);
    }

    @Override
    public Job editJob(long id, Job editedJob) throws NotFoundException {
        return merchantRepository.findById(id)
                .map(job -> {
                    job.setName(editedJob.getName());
                    return merchantRepository.save(job);
                }).orElseThrow(() -> new NotFoundException("Job with id: " + id + " was not found!"));
    }

    @Override
    public ResponseEntity<Object> deleteJob(long id) throws NotFoundException {
        return merchantRepository.findById(id)
                .map(job -> {
                    merchantRepository.delete(job);
                    return ResponseEntity.noContent().build();
                }).orElseThrow(() -> new NotFoundException("Job with id: " + id + " is not found!"));

    }

}

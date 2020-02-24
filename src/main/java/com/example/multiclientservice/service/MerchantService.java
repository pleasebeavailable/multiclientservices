package com.example.multiclientservice.service;

import com.example.multiclientservice.repository.MerchantRepository;
import com.example.multiclientservice.repository.model.Job;
import com.example.multiclientservice.web.dto.JobDto;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MerchantService implements IMerchantService {

    @Autowired
    private MerchantRepository merchantRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<JobDto> getAllJobs() {
        List<JobDto> jobDtos = new ArrayList<>();
        for (Job job :
                merchantRepository.findAll()) {
            jobDtos.add(modelMapper.map(job, JobDto.class));
        }
        return jobDtos;
    }

    @Override
    public List<JobDto> getAllMerchantJobs(long merchant_id) {
        List<JobDto> jobDtos = new ArrayList<>();
        for (Job job :
                merchantRepository.findJobsByMerchantId(merchant_id)) {
            jobDtos.add(modelMapper.map(job, JobDto.class));
        }
        return jobDtos;
    }

    @Override
    public JobDto getJob(long id) throws NotFoundException {
        return modelMapper.map(merchantRepository.findById(id).orElseThrow(() -> new NotFoundException("Job with id: " + id + " was not found!")), JobDto.class);
    }
    @Override
    public JobDto addJob(JobDto jobDto) {
        Job job = new Job();
        job.setName(jobDto.getName());
        return modelMapper.map(merchantRepository.save(job), JobDto.class);
    }

    @Override
    public List<JobDto> addJobs(List<JobDto> jobs) {
         //TODO
        return null;
    }

    @Override
    public JobDto editJob(long id, JobDto editedJob) throws NotFoundException {
        return merchantRepository.findById(id)
                .map(job -> {
                    job.setName(editedJob.getName());
                    return modelMapper.map(merchantRepository.save(job), JobDto.class);
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

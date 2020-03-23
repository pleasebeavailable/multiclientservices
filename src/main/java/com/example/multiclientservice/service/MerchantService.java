package com.example.multiclientservice.service;

import com.example.multiclientservice.repository.CategoryRepository;
import com.example.multiclientservice.repository.MerchantRepository;
import com.example.multiclientservice.repository.UserRepository;
import com.example.multiclientservice.repository.model.Job;
import com.example.multiclientservice.repository.model.User;
import com.example.multiclientservice.web.dto.CategoryDto;
import com.example.multiclientservice.web.dto.JobDto;
import com.example.multiclientservice.web.dto.JobDtoGui;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<JobDto> getAllJobs() {
        List<JobDto> jobDtos = new ArrayList<>();
        for (Job job :
                merchantRepository.findAll()) {

            jobDtos.add(getJobDto(job));
        }
        return jobDtos;
    }

    @Override
    public List<JobDto> getAllMerchantJobs(long merchant_id) {
        List<JobDto> jobDtos = new ArrayList<>();
        List<Job> jobs = merchantRepository.findJobsByMerchantId(merchant_id);
        for (Job job : jobs) {
            jobDtos.add(getJobDto(job));
        }
        return jobDtos;
    }

    @Override
    public JobDto getJob(long id) throws NotFoundException {
        Job job = merchantRepository.findById(id).orElseThrow(() -> new NotFoundException("Job with id: " + id + " was not found!"));
        return getJobDto(job);
    }

    @Override
    public JobDto addJob(JobDtoGui jobDto) {
        Job job = new Job();
        User user = userRepository.findById(jobDto.getUserId()).orElseThrow(() -> new IllegalArgumentException("User with id: " + jobDto.getUserId() + " does not exist!"));
        job.setName(jobDto.getName());
        job.setCategory(jobDto.getCategory());
        job.setUser(user);
        return modelMapper.map(merchantRepository.save(job), JobDto.class);
    }

    @Override
    public JobDto editJob(long id, JobDtoGui editedJob) throws NotFoundException {
        return merchantRepository.findById(id)
                .map(job -> {
                    job.setName(editedJob.getName());
                    job.setCategory(editedJob.getCategory());
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


    private JobDto getJobDto(Job job) {
        CategoryDto categoryDto = modelMapper.map(categoryRepository.findByName(job.getCategory()), CategoryDto.class);
        JobDto jobDto = new JobDto();
        jobDto.setId(job.getId());
        jobDto.setName(job.getName());
        jobDto.setCategory(categoryDto);
        jobDto.setUserId(job.getUser().getId());
        return jobDto;
    }
}

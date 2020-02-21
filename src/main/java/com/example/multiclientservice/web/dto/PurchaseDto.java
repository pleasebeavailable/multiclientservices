package com.example.multiclientservice.web.dto;


import com.example.multiclientservice.repository.model.Job;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class PurchaseDto {

    private long id;

    private List<JobDto> jobs = new ArrayList<>();

    public PurchaseDto() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<JobDto> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        setJobDtos(jobs);
    }

    private void setJobDtos(List<Job> jobs) {
        jobs.forEach(job -> {
            JobDto jobDto = new JobDto();
            jobDto.setId(job.getId());
            jobDto.setName(job.getName());

            this.jobs.add(jobDto);
        });
    }
}

package com.example.multiclientservice.web.controller;

import com.example.multiclientservice.service.MerchantService;
import com.example.multiclientservice.web.dto.JobDto;
import com.example.multiclientservice.web.dto.JobDtoGui;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/merchant")
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    @GetMapping("/allJobs")
    public List<JobDto> getAllJobs() {
        return merchantService.getAllJobs();
    }

    @GetMapping("/allMerchantJobs/{merchant_id}")
    public List<JobDto> getMerchantJobs(@PathVariable long merchant_id) {
        return merchantService.getAllMerchantJobs(merchant_id);
    }

    @GetMapping("/getJob/{job_id}")
    public JobDto getJob(@PathVariable long job_id) throws NotFoundException {
        return merchantService.getJob(job_id);
    }
    @PostMapping("addNewJob")
    public JobDto addNewJob(@Valid @RequestBody JobDtoGui job) {
        return merchantService.addJob(job);
    }

    @PutMapping("editJob/{job_id}")
    public JobDto editJob(@PathVariable long job_id, @Valid @RequestBody JobDtoGui job) throws NotFoundException {
        return merchantService.editJob(job_id, job);
    }
    @DeleteMapping("/deleteJob/{job_id}")
    public ResponseEntity<Object> deleteJob(@PathVariable long job_id) throws NotFoundException {

        return merchantService.deleteJob(job_id);
    }
}

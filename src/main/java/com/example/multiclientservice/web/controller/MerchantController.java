package com.example.multiclientservice.web.controller;

import com.example.multiclientservice.service.MerchantService;
import com.example.multiclientservice.web.dto.JobDto;
import org.springframework.beans.factory.annotation.Autowired;
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
    @PostMapping("addNewJob")
    public JobDto addNewJob(@Valid @RequestBody JobDto job) {
        return merchantService.addJob(job);
    }

}

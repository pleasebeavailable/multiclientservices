package com.example.multiclientservice.web.controller;

import com.example.multiclientservice.repository.model.Job;
import com.example.multiclientservice.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/merchant")
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    @PostMapping("add")
    public String addNewJob(@RequestBody Job job) {
        return merchantService.addJob(job).getName();
    }

}

package com.example.multiclientservice.web.controller;

import com.example.multiclientservice.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/merchant")
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    @GetMapping("/{name}")
    public String getJobName(@PathVariable String name) {
        return merchantService.findByName(name).getName();
    }
}

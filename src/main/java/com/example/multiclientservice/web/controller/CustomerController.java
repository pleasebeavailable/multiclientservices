package com.example.multiclientservice.web.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/merchant")
public class CustomerController {

    @GetMapping("")
    public String testSecurity() {
        return "works";
    }
}

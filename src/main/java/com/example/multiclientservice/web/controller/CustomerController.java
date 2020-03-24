package com.example.multiclientservice.web.controller;

import com.example.multiclientservice.repository.UserRepository;
import com.example.multiclientservice.service.CustomerService;
import com.example.multiclientservice.web.dto.PurchaseDto;
import com.example.multiclientservice.web.dto.PurchaseOrderDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/{purchase}")
    public ResponseEntity<Object> purchaseService(@RequestBody PurchaseDto purchaseDto) throws JsonProcessingException {

        return customerService.purchaseJob(purchaseDto);
    }
}

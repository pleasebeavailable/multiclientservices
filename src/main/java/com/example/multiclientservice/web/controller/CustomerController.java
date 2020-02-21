package com.example.multiclientservice.web.controller;

import com.example.multiclientservice.service.CustomerService;
import com.example.multiclientservice.web.dto.PurchaseDto;
import com.example.multiclientservice.web.dto.PurchaseOrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/{purchase}")
    public PurchaseDto purchaseService(@RequestBody PurchaseOrderDto purchaseOrder) {

        return customerService.purchaseService(purchaseOrder);
    }
}

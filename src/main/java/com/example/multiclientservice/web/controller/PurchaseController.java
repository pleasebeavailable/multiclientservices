package com.example.multiclientservice.web.controller;

import com.example.multiclientservice.web.dto.PurchaseDto;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/purchase")
public class PurchaseController {

    @PostMapping("")
    public PurchaseDto purchaseJob(@Valid @RequestBody PurchaseDto purchaseDto) {

    }
}

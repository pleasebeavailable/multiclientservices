package com.example.multiclientservice.web.controller;

import com.example.multiclientservice.service.CustomerService;
import com.example.multiclientservice.web.dto.PurchaseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("allUserPurchases/{user_id}")
    public List<PurchaseDto> getAllUserPurchases(@PathVariable long user_id) throws NotFoundException, JsonProcessingException {

        return customerService.getAllUserPurchases(user_id);
    }

    @PostMapping("/purchase")
    public ResponseEntity<Object> purchaseService(@Valid @RequestBody PurchaseDto purchaseDto) throws JsonProcessingException {

        return customerService.purchaseJob(purchaseDto);
    }
}

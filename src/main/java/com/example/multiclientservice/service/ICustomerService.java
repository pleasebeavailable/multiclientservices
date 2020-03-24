package com.example.multiclientservice.service;

import com.example.multiclientservice.web.dto.PurchaseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;


public interface ICustomerService {

    ResponseEntity<Object> purchaseJob(PurchaseDto purchaseOrder) throws JsonProcessingException;

}

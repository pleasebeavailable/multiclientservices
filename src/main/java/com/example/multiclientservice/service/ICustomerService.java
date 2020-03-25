package com.example.multiclientservice.service;

import com.example.multiclientservice.web.dto.PurchaseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface ICustomerService {

    ResponseEntity<Object> purchaseJob(PurchaseDto purchaseOrder) throws JsonProcessingException;

    List<PurchaseDto> getAllUserPurchases(long user_id) throws JsonProcessingException, NotFoundException;
}

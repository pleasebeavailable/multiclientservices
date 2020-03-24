package com.example.multiclientservice.service;

import com.example.multiclientservice.repository.CustomerRepository;
import com.example.multiclientservice.repository.MerchantRepository;
import com.example.multiclientservice.repository.UserRepository;
import com.example.multiclientservice.repository.model.Job;
import com.example.multiclientservice.repository.model.Purchase;
import com.example.multiclientservice.repository.model.User;
import com.example.multiclientservice.web.dto.PurchaseDto;
import com.example.multiclientservice.web.dto.json.PurchaseData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MerchantRepository merchantRepository;

    @Autowired
    private UserRepository userRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public ResponseEntity<Object> purchaseJob(PurchaseDto purchaseDto) throws JsonProcessingException {
        Purchase purchase = new Purchase();

        return savePurchase(purchaseDto, purchase);
    }

    private ResponseEntity<Object> savePurchase(PurchaseDto purchaseDto, Purchase purchase) throws JsonProcessingException {
        PurchaseData purchaseData = objectMapper.readValue(purchaseDto.getPurchaseData(), PurchaseData.class);
        User user = userRepository.findById(purchaseData.getUserId()).orElseThrow(() -> new EntityNotFoundException("User not found !"));
        Job job = merchantRepository.findById(purchaseData.getJobId()).orElseThrow(() -> new EntityNotFoundException("Job not found !"));

        purchase.setJob(job);
        purchase.setUser(user);
        purchase.setAddress(purchaseDto.getAddress());
        purchase.setPurchaseData(purchaseDto.getPurchaseData());

        customerRepository.save(purchase);

        return ResponseEntity.noContent().build();
    }
}

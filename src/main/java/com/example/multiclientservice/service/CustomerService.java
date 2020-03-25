package com.example.multiclientservice.service;

import com.example.multiclientservice.repository.CustomerRepository;
import com.example.multiclientservice.repository.MerchantRepository;
import com.example.multiclientservice.repository.UserRepository;
import com.example.multiclientservice.repository.model.Purchase;
import com.example.multiclientservice.repository.model.User;
import com.example.multiclientservice.web.dto.JobDto;
import com.example.multiclientservice.web.dto.PurchaseDto;
import com.example.multiclientservice.web.dto.json.PurchaseData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MerchantRepository merchantRepository;

    @Autowired
    private MerchantService merchantService;

    @Autowired
    private UserRepository userRepository;


    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<PurchaseDto> getAllUserPurchases(long user_id) throws JsonProcessingException, NotFoundException {
        List<PurchaseDto> purchaseDtos = new ArrayList<>();
        List<Purchase> purchases = customerRepository.findAllByUserId(user_id);
        for (Purchase p :
                purchases) {
            purchaseDtos.add(getPurchaseDto(p));
        }
        return purchaseDtos;
    }

    @Override
    public ResponseEntity<Object> purchaseJob(PurchaseDto purchaseDto) throws JsonProcessingException {
        Purchase purchase = new Purchase();

        return savePurchase(purchaseDto, purchase);
    }

    private PurchaseDto getPurchaseDto(Purchase p) throws JsonProcessingException, NotFoundException {
        PurchaseData purchaseData = objectMapper.readValue(p.getPurchaseData(), PurchaseData.class);
        JobDto jobDto = merchantService.getJob(purchaseData.getJobId());
        PurchaseDto pDto = new PurchaseDto();
        pDto.setId(p.getId());
        pDto.setAddress(p.getAddress());
        pDto.setPurchaseData(p.getPurchaseData());
        pDto.setJobDto(jobDto);
        return pDto;
    }

    private ResponseEntity<Object> savePurchase(PurchaseDto purchaseDto, Purchase purchase) throws JsonProcessingException {
        PurchaseData purchaseData = objectMapper.readValue(purchaseDto.getPurchaseData(), PurchaseData.class);
        User user = userRepository.findById(purchaseData.getUserId()).orElseThrow(() -> new EntityNotFoundException("User not found !"));

        purchase.setJob(merchantRepository.findById(purchaseData.getJobId()).orElseThrow(() -> new EntityNotFoundException("Job not found !")));
        purchase.setUser(user);
        purchase.setAddress(purchaseDto.getAddress());
        purchase.setPurchaseData(purchaseDto.getPurchaseData());

        customerRepository.save(purchase);

        return ResponseEntity.noContent().build();
    }
}

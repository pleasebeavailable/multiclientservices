package com.example.multiclientservice.service;

import com.example.multiclientservice.repository.CustomerRepository;
import com.example.multiclientservice.repository.MerchantRepository;
import com.example.multiclientservice.repository.model.Job;
import com.example.multiclientservice.repository.model.Purchase;
import com.example.multiclientservice.web.dto.JobDto;
import com.example.multiclientservice.web.dto.PurchaseDto;
import com.example.multiclientservice.web.dto.PurchaseOrderDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MerchantRepository merchantRepository;

    @Override
    public PurchaseDto purchaseService(PurchaseOrderDto purchaseOrder) {
        Purchase purchase = new Purchase();

        List<Job> jobs = merchantRepository.findAll();
        List<Job> filteredJobs = jobs.stream().filter(job -> purchaseOrder.getJobIds().contains(job.getId())).collect(Collectors.toList());

        purchase.setJobs(filteredJobs);
        purchase = customerRepository.save(purchase);


        return mapPurchaseDto(purchase);

    }

    private PurchaseDto mapPurchaseDto(Purchase purchase) {
        PurchaseDto purchaseDto = new PurchaseDto();
        purchaseDto.setId(purchase.getId());
        purchaseDto.setJobs(purchase.getJobs());

        return purchaseDto;
    }
}

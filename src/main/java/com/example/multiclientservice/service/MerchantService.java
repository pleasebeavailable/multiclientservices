package com.example.multiclientservice.service;

import com.example.multiclientservice.repository.MerchantRepository;
import com.example.multiclientservice.repository.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantService implements IMerchantService {

    @Autowired
    private MerchantRepository merchantRepository;


    @Override
    public Job findByName(String name) {
        return merchantRepository.findByName(name);
    }

}

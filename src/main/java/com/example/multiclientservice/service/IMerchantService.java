package com.example.multiclientservice.service;

import com.example.multiclientservice.repository.model.Job;

public interface IMerchantService {
    Job findByName(String name);
}

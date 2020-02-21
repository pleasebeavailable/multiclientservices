package com.example.multiclientservice.service;

import com.example.multiclientservice.web.dto.PurchaseDto;
import com.example.multiclientservice.web.dto.PurchaseOrderDto;



public interface ICustomerService {

    PurchaseDto purchaseService(PurchaseOrderDto purchaseOrder);

}

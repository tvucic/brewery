package com.tomo.brewery.services;

import com.tomo.brewery.web.model.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements  CustomerService
{
    @Override
    public CustomerDTO getCustomerId(UUID customerId)
    {
        return CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("John Doe").build();
    }
}

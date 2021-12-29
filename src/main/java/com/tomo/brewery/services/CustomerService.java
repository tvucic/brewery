package com.tomo.brewery.services;

import com.tomo.brewery.web.model.CustomerDTO;

import java.util.UUID;

public interface CustomerService
{
    CustomerDTO getCustomerId(UUID customerId);
}

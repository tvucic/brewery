package com.tomo.brewery.services;

import com.tomo.brewery.web.model.BeerDTO;
import com.tomo.brewery.web.model.CustomerDTO;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements  CustomerService
{
    static Logger LOG = Logger.getLogger(CustomerServiceImpl.class);

    @Override
    public CustomerDTO getCustomerId(UUID customerId)
    {
        return CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("John Doe").build();
    }

    @Override
    public CustomerDTO saveNewCustomer(CustomerDTO customerDTO)
    {
        return CustomerDTO.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDTO customerDTO)
    {
        // todo impl would need real implementation
    }

    @Override
    public void deleteById(UUID customerId)
    {
        LOG.debug("Customer deleting...");
    }

}

package com.tomo.brewery.web.controller;

import com.tomo.brewery.services.CustomerService;
import com.tomo.brewery.web.model.BeetDTO;
import com.tomo.brewery.web.model.CustomerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController
{
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService)
    {
        this.customerService = customerService;
    }

    @GetMapping({"/{customerId}"}) // Spring will automatically match customerId parameter name, but with PathVariable it will do it explicitly.
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable("customerId") UUID customerId)
    {
        return new ResponseEntity<>(customerService.getCustomerId(customerId), HttpStatus.OK);
    }
}

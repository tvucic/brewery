package com.tomo.brewery.web.controller;

import com.tomo.brewery.services.CustomerService;
import com.tomo.brewery.web.model.BeerDTO;
import com.tomo.brewery.web.model.CustomerDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping // POST - create new customer
    public ResponseEntity handlePost(@RequestBody CustomerDTO customerDTO)
    {
        CustomerDTO savedCustomerDTO = customerService.saveNewCustomer(customerDTO);

        HttpHeaders headers = new HttpHeaders();
        //todo add host name to url
        headers.add("Location", "/api/v1/customer" + savedCustomerDTO.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{customerId}"}) // Idempotent method
    public ResponseEntity handleUpdate(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDTO customerDTO)
    {
        customerService.updateCustomer(customerId, customerDTO);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{customerId}"})
    public void deleteCustomer(@PathVariable("customerId") UUID customerId)
    {
        customerService.deleteById(customerId);
    }
}

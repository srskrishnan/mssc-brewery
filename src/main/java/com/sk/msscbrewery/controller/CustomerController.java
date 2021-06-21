package com.sk.msscbrewery.controller;

import com.sk.msscbrewery.services.CustomerService;
import com.sk.msscbrewery.web.model.BeerDto;
import com.sk.msscbrewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable UUID customerId) {
        return new ResponseEntity<>(customerService.getCustomerId(customerId),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createCustomer(@RequestBody  CustomerDto customerDto) {

        CustomerDto savedDto = customerService.saveCustomer(customerDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/customer/" + savedDto.getId().toString() );

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity updateCustomer(@PathVariable UUID customerId, @RequestBody  CustomerDto customerDto) {

        customerService.updateCustomer(customerId,customerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteBeer(@PathVariable UUID customerId) {
        customerService.deleteCustomer(customerId);
    }




}

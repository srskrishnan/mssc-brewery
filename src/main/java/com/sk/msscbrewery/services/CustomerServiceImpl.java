package com.sk.msscbrewery.services;

import com.sk.msscbrewery.web.model.BeerDto;
import com.sk.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerId(UUID customerId) {
        return CustomerDto.builder()
                .id(customerId)
                .name("SK Ramasamy")
                .build();
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        return CustomerDto.builder().id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        //// TODO: 6/21/2021
    }

    @Override
    public void deleteCustomer(UUID customerId) {
        log.info("Deleting the Customer ***************");
    }
}

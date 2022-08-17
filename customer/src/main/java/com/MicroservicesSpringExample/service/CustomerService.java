package com.MicroservicesSpringExample.service;

import com.MicroservicesSpringExample.entity.Customer;
import com.MicroservicesSpringExample.entity.CustomerRegisrationRequest;
import com.MicroservicesSpringExample.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public record CustomerService(CustomerRepository customerRepository) {

    public void registerCustomer(CustomerRegisrationRequest request) {
        Customer customer = Customer.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .build();

        //to save the information
        customerRepository.save(customer);

    }

}
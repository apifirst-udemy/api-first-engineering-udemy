package com.rsouza01.apifirst_server.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.rsouza01.apifirst.model.CustomerDto;
import com.rsouza01.apifirst_server.repositories.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<CustomerDto> listCustomers() {
        return StreamSupport.stream(customerRepository.findAll().spliterator(), false).toList();
    }

    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return customerRepository.findById(customerId).orElseThrow();
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customer) {
        return customerRepository.save(customer);
    }
}

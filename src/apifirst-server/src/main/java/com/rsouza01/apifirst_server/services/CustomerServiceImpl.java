package com.rsouza01.apifirst_server.services;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.rsouza01.apifirst.model.Customer;
import com.rsouza01.apifirst_server.repositories.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> listCustomers() {
        return StreamSupport.stream(customerRepository.findAll().spliterator(), false).toList();
    }

}

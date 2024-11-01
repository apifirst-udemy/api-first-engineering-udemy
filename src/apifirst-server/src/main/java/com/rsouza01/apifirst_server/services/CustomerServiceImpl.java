package com.rsouza01.apifirst_server.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rsouza01.apifirst.model.CustomerDto;
import com.rsouza01.apifirst_server.domain.Customer;
import com.rsouza01.apifirst_server.mappers.CustomerMapper;
import com.rsouza01.apifirst_server.repositories.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Transactional
    @Override
    public CustomerDto saveNewCustomer(CustomerDto customer) {
        Customer savedCustomer = customerRepository.save(customerMapper.customerDtoToCustomer(customer));
        customerRepository.flush();
        return customerMapper.customerToCustomerDto(savedCustomer);
    }

    @Override
    public List<CustomerDto> listCustomers() {
        return StreamSupport.stream(customerRepository.findAll().spliterator(),
                false)
                .map(customerMapper::customerToCustomerDto)
                .toList();
    }

    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return customerMapper.customerToCustomerDto(customerRepository.findById(customerId).orElseThrow());
    }
}

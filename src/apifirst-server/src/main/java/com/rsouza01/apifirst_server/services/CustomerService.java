package com.rsouza01.apifirst_server.services;

import java.util.List;
import java.util.UUID;

import com.rsouza01.apifirst.model.CustomerDto;


public interface CustomerService {

    List<CustomerDto> listCustomers();

    CustomerDto getCustomerById(UUID customerId);

    CustomerDto saveNewCustomer(CustomerDto customer);
}

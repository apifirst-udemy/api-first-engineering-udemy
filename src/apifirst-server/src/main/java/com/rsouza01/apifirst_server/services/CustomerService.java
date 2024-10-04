package com.rsouza01.apifirst_server.services;

import java.util.List;
import java.util.UUID;

import com.rsouza01.apifirst.model.Customer;


public interface CustomerService {

    List<Customer> listCustomers();

    Customer getCustomerById(UUID customerId);

    Customer saveNewCustomer(Customer customer);
}

package com.rsouza01.apifirst_server.controllers;

import jakarta.servlet.Filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rsouza01.apifirst.model.CustomerDto;
import com.rsouza01.apifirst.model.OrderDto;
import com.rsouza01.apifirst.model.ProductDto;
import com.rsouza01.apifirst_server.mappers.CustomerMapper;
import com.rsouza01.apifirst_server.repositories.CustomerRepository;
import com.rsouza01.apifirst_server.repositories.OrderRepository;
import com.rsouza01.apifirst_server.repositories.ProductRepository;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class BaseTest {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    WebApplicationContext wac;

    public MockMvc mockMvc;

    CustomerDto testCustomer;
    ProductDto testProduct;
    OrderDto testOrder;

    @Autowired
    Filter validationFilter;

    @Autowired
    CustomerMapper customerMapper;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).addFilter(validationFilter).build();

        testCustomer = customerMapper.customerToDto(customerRepository.findAll().iterator().next());
        // testProduct = productRepository.findAll().iterator().next();
        // testOrder = orderRepository.findAll().iterator().next();
    }
}

package com.rsouza01.apifirst_server.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rsouza01.apifirst.model.Customer;
import com.rsouza01.apifirst_server.services.CustomerService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequiredArgsConstructor
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {

    public static final String BASE_URL = "/v1/customers";
    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> listCustomers() {
        return ResponseEntity.ok(customerService.listCustomers());
    }
    
}

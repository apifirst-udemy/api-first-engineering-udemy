package com.rsouza01.apifirst_server.controllers;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.rsouza01.apifirst.model.CustomerDto;
import com.rsouza01.apifirst_server.services.CustomerService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {

    public static final String BASE_URL = "/v1/customers";
    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerDto>> listCustomers() {
        return ResponseEntity.ok(customerService.listCustomers());
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("customerId") UUID customerId) {
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }

    @PostMapping
    public ResponseEntity<Void> saveNewCustomer(@RequestBody CustomerDto customer) {
        CustomerDto savedCustomer = customerService.saveNewCustomer(customer);

        UriComponents uriComponents = UriComponentsBuilder.fromPath(BASE_URL + "/{customer_id}")
                .buildAndExpand(savedCustomer.getId());

        return ResponseEntity.created(URI.create(uriComponents.getPath())).build();
    }

}

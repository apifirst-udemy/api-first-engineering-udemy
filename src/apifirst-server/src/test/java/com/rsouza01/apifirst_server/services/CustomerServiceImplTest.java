package com.rsouza01.apifirst_server.services;

import com.rsouza01.apifirst_server.domain.Customer;
import com.rsouza01.apifirst_server.domain.PaymentMethod;
import com.rsouza01.apifirst_server.repositories.CustomerRepository;
import com.rsouza01.apifirst.model.AddressDto;
import com.rsouza01.apifirst.model.CustomerDto;
import com.rsouza01.apifirst.model.NameDto;
import com.rsouza01.apifirst.model.PaymentMethodDto;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CustomerServiceImplTest {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerRepository customerRepository;

    @Transactional
    @Test
    void saveNewCustomer() {
        CustomerDto customerDto = createCustomerDTO();

        CustomerDto savedCustomer = customerService.saveNewCustomer(customerDto);

        assertNotNull(savedCustomer);
        assertNotNull(savedCustomer.getId());

        Customer customer = customerRepository.findById(savedCustomer.getId()).orElseThrow();

        assertNotNull(customer.getPaymentMethods());

        PaymentMethod paymentMethod = customer.getPaymentMethods().get(0);

        assertEquals(customerDto.getName().getFirstName(), customer.getName().getFirstName());

    }

    @Test
    void listCustomers() {
    }

    @Test
    void getCustomerById() {
    }

    CustomerDto createCustomerDTO() {
        return CustomerDto.builder()
                .name(NameDto.builder()
                        .firstName("John")
                        .lastName("Doe")
                        .build())
                .billToAddress(AddressDto.builder()
                        .addressLine1("1234 Main Street")
                        .city("San Diego")
                        .state("CA")
                        .zip("92101")
                        .build())
                .shipToAddress(AddressDto.builder()
                        .addressLine1("1234 Main Street")
                        .city("San Diego")
                        .state("CA")
                        .zip("92101")
                        .build())
                .email("joe@example.com")
                .phone("555-555-5555")
                .paymentMethods(Arrays.asList(PaymentMethodDto.builder()
                                .displayName("My Card")
                        .cardNumber(1234123412)
                        .expiryMonth(12)
                        .expiryYear(2020)
                        .cvv(123).build()))
                .build();
    }
}
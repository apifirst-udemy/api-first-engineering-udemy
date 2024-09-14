package com.rsouza01.apifirst_server.bootstrap;

import java.time.OffsetDateTime;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rsouza01.apifirst.model.Address;
import com.rsouza01.apifirst.model.Customer;
import com.rsouza01.apifirst.model.Name;
import com.rsouza01.apifirst.model.PaymentMethod;
import com.rsouza01.apifirst_server.repositories.CustomerRepository;

import java.util.List;

@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        Address address1 = Address.builder()
                .addressLine1("1234 W Some Street")
                .city("Some City")
                .state("FL")
                .zip("33701")
                .dateCreated(OffsetDateTime.now())
                .dateUpdated(OffsetDateTime.now())
                .build();

        Customer customer1 = Customer.builder()
                .name(Name.builder()
                        .firstName("John")
                        .lastName("Thompson")
                        .build())
                .billToAddress(address1)
                .shipToAddress(address1)
                .email("john@springframework.guru")
                .phone("800-555-1212")
                .dateCreated(OffsetDateTime.now())
                .dateUpdated(OffsetDateTime.now())
                .paymentMethods(List.of(PaymentMethod.builder()
                        .displayName("Card 1")
                        .cardNumber(12341234)
                        .expiryMonth(12)
                        .expiryYear(26)
                        .dateCreated(OffsetDateTime.now())
                        .dateUpdated(OffsetDateTime.now())
                        .build()))
                .build();

        Address address2 = Address.builder()
                .addressLine1("1234 W Some Street")
                .city("Some City")
                .state("FL")
                .zip("33701")
                .dateCreated(OffsetDateTime.now())
                .dateUpdated(OffsetDateTime.now())
                .build();

        Customer customer2 = Customer.builder()
                .name(Name.builder()
                        .firstName("Jim")
                        .lastName("Smith")
                        .build())
                .billToAddress(address2)
                .shipToAddress(address2)
                .email("jim@springframework.guru")
                .phone("800-555-1212")
                .dateCreated(OffsetDateTime.now())
                .dateUpdated(OffsetDateTime.now())
                .paymentMethods(List.of(PaymentMethod.builder()
                        .displayName("Card 2")
                        .cardNumber(1234888)
                        .expiryMonth(12)
                        .expiryYear(26)
                        .dateCreated(OffsetDateTime.now())
                        .dateUpdated(OffsetDateTime.now())
                        .build()))
                .build();

        customerRepository.save(customer1);
        customerRepository.save(customer2);
    }
}

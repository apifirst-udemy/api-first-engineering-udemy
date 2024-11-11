package com.rsouza01.apifirst_server.mappers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rsouza01.apifirst.model.AddressDto;
import com.rsouza01.apifirst.model.CustomerDto;
import com.rsouza01.apifirst.model.DimensionsDto;
import com.rsouza01.apifirst.model.ImageDto;
import com.rsouza01.apifirst.model.NameDto;
import com.rsouza01.apifirst.model.PaymentMethodDto;
import com.rsouza01.apifirst.model.ProductCreateDto;
import com.rsouza01.apifirst_server.domain.Address;
import com.rsouza01.apifirst_server.domain.Category;
import com.rsouza01.apifirst_server.domain.Customer;
import com.rsouza01.apifirst_server.domain.Name;
import com.rsouza01.apifirst_server.domain.PaymentMethod;
import com.rsouza01.apifirst_server.repositories.CategoryRepository;

import jakarta.persistence.Embedded;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CustomerMapperTest {

    @Autowired
    CustomerMapper customerMapper;

    @Test
    void customerDtoToCustomer() {

        //fail if no category found
        var customerDto = buildCustomerDto();

        var customer = customerMapper.customerDtoToCustomer(customerDto);

        assertNotNull(customer);
        assertEquals(customer.getId(), customerDto.getId());
        assertEquals(customer.getName().getFirstName(), customerDto.getName().getFirstName());
        assertEquals(customer.getName().getLastName(), customerDto.getName().getLastName());
        assertEquals(customer.getEmail(), customerDto.getEmail());
        assertEquals(customer.getPhone(), customerDto.getPhone());
        assertNotNull(customer.getBillToAddress());
        // TODO: Deep check
        assertNotNull(customer.getShipToAddress());
        // TODO: Deep check

        assertNotNull(customer.getPaymentMethods());
        assertFalse(customer.getPaymentMethods().isEmpty());
        customer.getPaymentMethods().forEach(paymentMethod -> {
            System.out.println("paymentMethod: " + paymentMethod);
            // assertNotNull(paymentMethod.getCustomer());
            // assertEquals(paymentMethod.getCustomer().getId(), customer.getId());
            // assertNotNull(paymentMethod.getCardNumber());
        });


    



        // assertEquals(productCreateDto.getDescription(), product.getDescription());
        // assertEquals(productCreateDto.getCost(), product.getCost());
        // assertEquals(productCreateDto.getPrice(), product.getPrice());
        // assertEquals(productCreateDto.getDimensions().getHeight(), product.getDimensions().getHeight());
        // assertEquals(productCreateDto.getDimensions().getWidth(), product.getDimensions().getWidth());
        // assertEquals(productCreateDto.getDimensions().getLength(), product.getDimensions().getLength());
        // assertEquals(productCreateDto.getImages().get(0).getUrl(), product.getImages().get(0).getUrl());
        // assertEquals(productCreateDto.getImages().get(0).getAltText(), product.getImages().get(0).getAltText());
        // assertEquals(productCreateDto.getCategories().get(0), product.getCategories().get(0).getCategoryCode());

        //test to catch changes, fail test if fields are added
        // assertEquals(9, product.getClass().getDeclaredFields().length);

    }

    CustomerDto buildCustomerDto() {

        AddressDto address = AddressDto.builder()
                .addressLine1("1234 W Some Street")
                .city("Some City")
                .state("FL")
                .zip("33701")
                .dateCreated(OffsetDateTime.now())
                .dateUpdated(OffsetDateTime.now())
                .build();

        CustomerDto customerDto = CustomerDto.builder()
                .id(UUID.randomUUID())
                .name(NameDto.builder()
                        .firstName("Customer")
                        .lastName("Number1")
                        .build())
                .billToAddress(address)
                .shipToAddress(address)
                .email("customer1@api.first")
                .phone("800-555-1212")
                .dateCreated(OffsetDateTime.now())
                .dateUpdated(OffsetDateTime.now())
                .paymentMethods(List.of(PaymentMethodDto.builder()
                        .displayName("Card 1")
                        .cvv(123)
                        .cardNumber(12341234)
                        .expiryMonth(12)
                        .expiryYear(26)
                        .build()))
                .build();

        return customerDto;
    }
}
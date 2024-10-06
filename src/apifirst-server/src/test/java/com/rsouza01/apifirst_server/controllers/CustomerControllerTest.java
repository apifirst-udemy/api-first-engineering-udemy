package com.rsouza01.apifirst_server.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.rsouza01.apifirst.model.AddressDto;
import com.rsouza01.apifirst.model.CustomerDto;
import com.rsouza01.apifirst.model.NameDto;
import com.rsouza01.apifirst.model.PaymentMethodDto;

import static org.hamcrest.Matchers.greaterThan;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;

@SpringBootTest
public class CustomerControllerTest extends BaseTest {

    @DisplayName("Get by Id")
    @Test
    void testGetCustomerById() throws Exception {
        mockMvc.perform(get(CustomerController.BASE_URL + "/{customerId}", testCustomer.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(testCustomer.getId().toString()));
    }

    @DisplayName("Test list customers")
    @Test
    void testListCustomers() throws Exception {
        mockMvc.perform(get(CustomerController.BASE_URL)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()", greaterThan(0)));
    }

    @DisplayName("Create customer")
    @Test
    void testCreateCustomer() throws Exception {
        AddressDto address = AddressDto.builder()
                .addressLine1("1234 W Some Street")
                .city("Some City")
                .state("FL")
                .zip("33701")
                .dateCreated(OffsetDateTime.now())
                .dateUpdated(OffsetDateTime.now())
                .build();

        CustomerDto customer = CustomerDto.builder()
                .id(UUID.randomUUID())
                .name(NameDto.builder()
                        .firstName("Customer")
                        .lastName("Example")
                        .build())
                .billToAddress(address)
                .shipToAddress(address)
                .email("customer@example.com")
                .phone("800-555-1212")
                .dateCreated(OffsetDateTime.now())
                .dateUpdated(OffsetDateTime.now())
                .paymentMethods(List.of(PaymentMethodDto.builder()
                        .displayName("Card 1")
                        .cvv(123)
                        .cardNumber(12341234)
                        .expiryMonth(12)
                        .expiryYear(26)
                        .dateCreated(OffsetDateTime.now())
                        .dateUpdated(OffsetDateTime.now())
                        .build()))
                .build();

        mockMvc.perform(post(CustomerController.BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(customer)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"));
    }
}

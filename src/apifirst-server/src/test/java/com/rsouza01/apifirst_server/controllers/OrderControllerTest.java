package com.rsouza01.apifirst_server.controllers;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.rsouza01.apifirst.model.OrderCreateDto;
import com.rsouza01.apifirst.model.OrderLineCreateDto;
import com.rsouza01.apifirst_server.domain.Customer;

import jakarta.transaction.Transactional;

import static org.hamcrest.Matchers.greaterThan;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Disabled;

import java.util.Arrays;

@SpringBootTest
public class OrderControllerTest extends BaseTest {

        @DisplayName("Test list Orders")
        @Test
        void testListOrders() throws Exception {
                mockMvc.perform(get(OrderController.BASE_URL)
                                .accept(MediaType.APPLICATION_JSON))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.length()", greaterThan(0)));
        }

        @DisplayName("Get by Id")
        @Test
        void testGetOrderById() throws Exception {
                mockMvc.perform(get(OrderController.BASE_URL + "/{orderId}", testOrder.getId())
                                .accept(MediaType.APPLICATION_JSON))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.id").value(testOrder.getId().toString()));
        }

        @DisplayName("Create order")
        @Test
        @Transactional
        void testCreateOrder() throws Exception {

                OrderCreateDto orderCreate = OrderCreateDto.builder()
                                .customerId(testCustomer.getId())
                                .selectPaymentMethodId(testCustomer.getPaymentMethods().get(0).getId())
                                .orderLines(Arrays
                                                .asList(OrderLineCreateDto.builder().productId(testProduct.getId())
                                                                .orderQuantity(2).build()))
                                .build();

                mockMvc.perform(post(OrderController.BASE_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(orderCreate)))
                                .andDo(MockMvcResultHandlers.print())
                                .andExpect(status().isCreated())
                                .andExpect(header().exists("Location"));
        }
}

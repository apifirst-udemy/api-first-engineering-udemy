package com.rsouza01.apifirst_server.controllers;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import static org.hamcrest.Matchers.greaterThan;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class OrderControllerTest extends BaseTest {

    @DisplayName("Get by Id")
    @Test
    @Disabled
    void testGetOrderById() throws Exception {
        mockMvc.perform(get(OrderController.BASE_URL + "/{orderId}", testOrder.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(testOrder.getId().toString()));
    }

    @DisplayName("Test list Orders")
    @Test
    @Disabled
    void testListOrders() throws Exception {
        mockMvc.perform(get(OrderController.BASE_URL)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()", greaterThan(0)));
    }
}

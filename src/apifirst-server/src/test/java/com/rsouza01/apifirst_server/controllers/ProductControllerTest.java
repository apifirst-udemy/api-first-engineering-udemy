package com.rsouza01.apifirst_server.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.rsouza01.apifirst.model.DimensionsDto;
import com.rsouza01.apifirst.model.ImageDto;
import com.rsouza01.apifirst.model.ProductCreateDto;

import static org.hamcrest.Matchers.greaterThan;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

@SpringBootTest
// @Disabled
public class ProductControllerTest extends BaseTest {

    @DisplayName("Test list Products")
    @Test
    void testListProducts() throws Exception {
        mockMvc.perform(get(ProductController.BASE_URL)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()", greaterThan(0)));
    }

    @DisplayName("Get by Id")
    @Test
    void testGetProductById() throws Exception {
        mockMvc.perform(get(ProductController.BASE_URL + "/{productId}", testProduct.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(testProduct.getId().toString()));
    }

    @DisplayName("Create product")
    @Test
    void testCreateProduct() throws Exception {

        
        ProductCreateDto product = ProductCreateDto.builder()
                .description("null")
                .cost("1.00")
                .price("1.00")
                .categories(Arrays.asList("ELECTRONICS"))
                .images(Arrays.asList(ImageDto.builder()
                        .url("http://example.com/ImageDto.jpg")
                        .altText("Some image")
                        .build()))
                .dimensions(DimensionsDto.builder()
                        .length(10)
                        .width(10)
                        .height(10)
                        .build())
                .build();

        mockMvc.perform(post(ProductController.BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(product)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"));
    }
}

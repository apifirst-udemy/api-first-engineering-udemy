package com.rsouza01.apifirst_server.mappers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rsouza01.apifirst.model.DimensionsDto;
import com.rsouza01.apifirst.model.ImageDto;
import com.rsouza01.apifirst.model.ProductCreateDto;
import com.rsouza01.apifirst_server.domain.Category;
import com.rsouza01.apifirst_server.repositories.CategoryRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ProductMapperTest {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void productCreateDtoToProduct() {

        //fail if no category found
        Category category = categoryRepository.findByCategoryCode("ELECTRONICS").orElseThrow();
        var productCreateDto = buildProductCreateDto(category.getCategoryCode());

        var product = productMapper.productCreateDtoToProduct(productCreateDto);

        assertNotNull(product);
        assertEquals(productCreateDto.getDescription(), product.getDescription());
        assertEquals(productCreateDto.getCost(), product.getCost());
        assertEquals(productCreateDto.getPrice(), product.getPrice());
        assertEquals(productCreateDto.getDimensions().getHeight(), product.getDimensions().getHeight());
        assertEquals(productCreateDto.getDimensions().getWidth(), product.getDimensions().getWidth());
        assertEquals(productCreateDto.getDimensions().getLength(), product.getDimensions().getLength());
        assertEquals(productCreateDto.getImages().get(0).getUrl(), product.getImages().get(0).getUrl());
        assertEquals(productCreateDto.getImages().get(0).getAltText(), product.getImages().get(0).getAltText());
        assertEquals(productCreateDto.getCategories().get(0), product.getCategories().get(0).getCategoryCode());

        //test to catch changes, fail test if fields are added
        assertEquals(9, product.getClass().getDeclaredFields().length);

    }

    ProductCreateDto buildProductCreateDto(String cat) {
        return ProductCreateDto.builder()
                .price("1.0")
                .description("description")
                .images(Arrays.asList(ImageDto.builder()
                        .url("http://example.com/image.jpg")
                        .altText("Image Alt Text")
                        .build()))
                .categories(Arrays.asList(cat))
                .cost("1.0")
                .dimensions(DimensionsDto.builder()
                        .height(1)
                        .length(1)
                        .width(1)
                        .build())
                .build();
    }
}
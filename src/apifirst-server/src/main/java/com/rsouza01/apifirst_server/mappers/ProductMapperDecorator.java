package com.rsouza01.apifirst_server.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.rsouza01.apifirst.model.ProductCreateDto;
import com.rsouza01.apifirst.model.ProductDto;
import com.rsouza01.apifirst_server.domain.Category;
import com.rsouza01.apifirst_server.domain.Product;
import com.rsouza01.apifirst_server.repositories.CategoryRepository;

public abstract class ProductMapperDecorator implements ProductMapper {

    @Autowired
    @Qualifier("delegate")
    private ProductMapper productMapperDelegate;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Product productCreateDtoToProduct(ProductCreateDto productCreateDto) {
        if (productCreateDto != null) {
            Product product = productMapperDelegate.productCreateDtoToProduct(productCreateDto);

            if (productCreateDto.getCategories() != null) {
                List<Category> categories = new ArrayList<>();

                productCreateDto.getCategories().forEach(categoryCode -> {
                    categoryRepository.findByCategoryCode(categoryCode).ifPresent(categories::add);
                });

                product.setCategories(categories);

                return product;
            }
        }

        return null;
    }

    @Override
    public ProductDto productToProductDto(Product product) {
        return productMapperDelegate.productToProductDto(product);
    }

    @Override
    public Product productDtoToProduct(ProductDto productDto) {
        return productMapperDelegate.productDtoToProduct(productDto);
    }

}
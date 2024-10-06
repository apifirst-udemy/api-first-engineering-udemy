package com.rsouza01.apifirst_server.services;

import java.util.List;
import java.util.UUID;

import com.rsouza01.apifirst.model.ProductDto;


public interface ProductService {

    List<ProductDto> listProducts();

    ProductDto getProductById(UUID productId);

    ProductDto saveNewProduct(ProductDto product);
}

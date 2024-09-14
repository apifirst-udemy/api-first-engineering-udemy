package com.rsouza01.apifirst_server.services;

import java.util.List;
import java.util.UUID;

import com.rsouza01.apifirst.model.Product;


public interface ProductService {

    List<Product> listProducts();

    Product getProductById(UUID productId);
}

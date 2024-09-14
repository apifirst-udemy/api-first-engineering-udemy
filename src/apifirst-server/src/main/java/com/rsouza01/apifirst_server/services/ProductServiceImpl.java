package com.rsouza01.apifirst_server.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.rsouza01.apifirst.model.Product;
import com.rsouza01.apifirst_server.repositories.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> listProducts() {
        return StreamSupport.stream(productRepository.findAll().spliterator(), false).toList();
    }

    @Override
    public Product getProductById(UUID productId) {
        return productRepository.findById(productId).orElseThrow();
    }

}

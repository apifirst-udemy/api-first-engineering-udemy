package com.rsouza01.apifirst_server.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rsouza01.apifirst.model.ProductCreateDto;
import com.rsouza01.apifirst.model.ProductDto;
import com.rsouza01.apifirst_server.domain.Product;
import com.rsouza01.apifirst_server.mappers.ProductMapper;
import com.rsouza01.apifirst_server.repositories.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Transactional
    @Override
    public ProductDto saveNewProduct(ProductCreateDto productDto) {
        Product savedProduct = productRepository.save(productMapper.productCreateDtoToProduct(productDto));
        productRepository.flush();
        return productMapper.productToProductDto(savedProduct);
    }

    @Override
    public List<ProductDto> listProducts() {
        return StreamSupport.stream(productRepository.findAll().spliterator(),
                false)
                .map(productMapper::productToProductDto)
                .toList();
    }

    @Override
    public ProductDto getProductById(UUID productId) {
        return productMapper.productToProductDto(productRepository.findById(productId).orElseThrow());
    }
}

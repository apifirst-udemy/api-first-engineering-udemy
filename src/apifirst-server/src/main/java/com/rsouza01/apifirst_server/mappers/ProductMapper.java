package com.rsouza01.apifirst_server.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.rsouza01.apifirst.model.ProductDto;
import com.rsouza01.apifirst_server.domain.Product;

@Mapper
public interface ProductMapper {

    @Mapping(target = "dimensions", source = "dimension")
    ProductDto productToProductDto(Product product);

    @Mapping(target = "dimension", source = "dimensions")
    @Mapping(target = "dateCreated", ignore = true)
    @Mapping(target = "dateUpdated", ignore = true)
    Product productDtoToProduct(ProductDto productDto);
}

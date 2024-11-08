package com.rsouza01.apifirst_server.mappers;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.rsouza01.apifirst.model.ProductCreateDto;
import com.rsouza01.apifirst.model.ProductDto;
import com.rsouza01.apifirst_server.domain.Product;

@Mapper
@DecoratedWith(ProductMapperDecorator.class)
public interface ProductMapper {

    @Mapping(target = "dateCreated", ignore = true)
    @Mapping(target = "dateUpdated", ignore = true)
    Product productDtoToProduct(ProductDto productDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dateCreated", ignore = true)
    @Mapping(target = "dateUpdated", ignore = true)
    @Mapping(target = "categories", ignore = true)
    Product productCreateDtoToProduct(ProductCreateDto productCreateDto);

    ProductDto productToProductDto(Product product);}

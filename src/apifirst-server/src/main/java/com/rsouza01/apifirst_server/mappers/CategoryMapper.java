package com.rsouza01.apifirst_server.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.rsouza01.apifirst.model.CategoryDto;
import com.rsouza01.apifirst_server.domain.Category;

@Mapper
public interface CategoryMapper {
     CategoryDto categoryToCategoryDto(Category category);

    @Mapping(target = "products", ignore = true)
    Category categoryDtoToCategory(CategoryDto categoryDto);
}

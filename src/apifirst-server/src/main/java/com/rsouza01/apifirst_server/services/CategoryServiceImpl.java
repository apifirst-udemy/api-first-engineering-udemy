package com.rsouza01.apifirst_server.services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.rsouza01.apifirst.model.CategoryDto;
import com.rsouza01.apifirst_server.mappers.CategoryMapper;
import com.rsouza01.apifirst_server.repositories.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> listCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::categoryToCategoryDto)
                .toList();
    }
}

package com.rsouza01.apifirst_server.services;

import java.util.List;

import com.rsouza01.apifirst.model.CategoryDto;


public interface CategoryService {

    List<CategoryDto> listCategories();

}

package com.example.multiclientservice.service;

import com.example.multiclientservice.web.dto.CategoryDto;

import java.util.List;

public interface ICategoryService {

    List<CategoryDto> getCategories();

    CategoryDto findByName(String name);
}

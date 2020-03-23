package com.example.multiclientservice.service;

import com.example.multiclientservice.repository.CategoryRepository;
import com.example.multiclientservice.repository.model.Category;
import com.example.multiclientservice.web.dto.CategoryDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<CategoryDto> getCategories() {

        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> categoryDtos = new ArrayList<>();

        for (Category category :
                categories) {
            categoryDtos.add(modelMapper.map(category, CategoryDto.class));
        }
        return categoryDtos;

    }

    @Override
    public CategoryDto findByName(String name) {
        return modelMapper.map(categoryRepository.findByName(name), CategoryDto.class);
    }
}

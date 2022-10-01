package com.example.noronapp.service;

import com.example.noronapp.data.mappers.CategoryMapper;
import com.example.noronapp.data.model.Category;
import com.example.noronapp.data.response.CategoryResponse;
import com.example.noronapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    public List<CategoryResponse> getAllCategories() {
        return categoryMapper.categoriesToDtos((List<Category>) categoryRepository.findAll());
    }

    public CategoryResponse getCategoryById(int id) {
        return categoryMapper.categoryToDto(categoryRepository.findById(id).orElseGet(null));
    }

    public void saveCategory(CategoryResponse categoryResponse) {
        categoryRepository.save(categoryMapper.dtoToCategory(categoryResponse));
    }

}

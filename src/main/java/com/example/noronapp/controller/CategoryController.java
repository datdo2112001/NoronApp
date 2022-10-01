package com.example.noronapp.controller;

import com.example.noronapp.data.response.CategoryResponse;
import com.example.noronapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public List<CategoryResponse> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/category/{id}")
    public CategoryResponse getCategoryById (@PathVariable int id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/category")
    public ResponseEntity<CategoryResponse> saveCategory(@RequestBody CategoryResponse categoryResponse) {
        categoryService.saveCategory(categoryResponse);
        return ResponseEntity.ok(categoryResponse);
    }
}

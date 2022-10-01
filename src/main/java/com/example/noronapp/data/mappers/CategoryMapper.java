package com.example.noronapp.data.mappers;

import com.example.noronapp.data.model.Category;
import com.example.noronapp.data.response.CategoryResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category dtoToCategory(CategoryResponse categoryResponse);

    CategoryResponse categoryToDto(Category category);

    List<CategoryResponse> categoriesToDtos(List<Category> categories);
}

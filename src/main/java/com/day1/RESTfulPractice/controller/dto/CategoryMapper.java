package com.day1.RESTfulPractice.controller.dto;

import com.day1.RESTfulPractice.controller.dto.request.CategoryRequest;
import com.day1.RESTfulPractice.controller.dto.response.CategoryResponse;
import com.day1.RESTfulPractice.db.entities.CategoryEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryMapper {

    public CategoryEntity toEntity(CategoryRequest categoryRequest){
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryName(categoryRequest.getCategoryName());
        return categoryEntity;
    }

    public CategoryResponse toResponse (CategoryEntity categoryEntity){
        if(categoryEntity == null){
            return null;
        }
        return CategoryResponse.builder()
                .categoryName(categoryEntity.getCategoryName())
                .build();
    }

    public List<CategoryResponse> toResponseList(List<CategoryEntity> categoryEntity){
        return categoryEntity.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}

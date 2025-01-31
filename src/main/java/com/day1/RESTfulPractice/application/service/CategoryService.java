package com.day1.RESTfulPractice.application.service;

import com.day1.RESTfulPractice.controller.dto.CategoryMapper;
import com.day1.RESTfulPractice.controller.dto.request.CategoryRequest;
import com.day1.RESTfulPractice.controller.dto.response.CategoryResponse;
import com.day1.RESTfulPractice.db.CategoryRepository;
import com.day1.RESTfulPractice.db.entities.CategoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Transactional(readOnly = true)
    public List<CategoryResponse> getAllCategories(){
        List<CategoryEntity> categoryEntity = categoryRepository.findAll();
        return categoryMapper.toResponseList(categoryEntity);
    }

    public CategoryResponse createCategory(@RequestBody CategoryRequest categoryRequest){
        CategoryEntity categoryEntity = categoryMapper.toEntity(categoryRequest);
        CategoryEntity savedCategory = categoryRepository.save(categoryEntity);
        return categoryMapper.toResponse(savedCategory);
    }
}

package com.day1.RESTfulPractice.controller;

import com.day1.RESTfulPractice.application.service.CategoryService;
import com.day1.RESTfulPractice.controller.dto.request.CategoryRequest;
import com.day1.RESTfulPractice.controller.dto.response.CategoryResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
@Slf4j
public class CategoryController {

    private final CategoryService categoryService;

    //implements pageable
    @GetMapping
    public List<CategoryResponse> getAllCategories(){
        //reemplazar
        log.info("Executing get all categories");
        return categoryService.getAllCategories();
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryRequest categoryRequest){
        log.info("Executing create a category with this parameters{}", categoryRequest);
        CategoryResponse categoryResponse = categoryService.createCategory(categoryRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.createCategory(categoryRequest));
    }
}

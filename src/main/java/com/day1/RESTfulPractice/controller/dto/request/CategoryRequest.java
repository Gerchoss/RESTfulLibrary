package com.day1.RESTfulPractice.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequest {


    private Long id;

    @NotBlank( message = "CategoryName empty")
    private String categoryName;
}

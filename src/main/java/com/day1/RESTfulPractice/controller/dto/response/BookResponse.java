package com.day1.RESTfulPractice.controller.dto.response;

import com.day1.RESTfulPractice.db.entities.CategoryEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookResponse {

    private Long id;
    private String isbn;
    private String title;
    private String author;
    private Integer pages;
    private CategoryEntity category;

}

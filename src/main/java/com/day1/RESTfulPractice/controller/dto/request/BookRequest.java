package com.day1.RESTfulPractice.controller.dto.request;

import com.day1.RESTfulPractice.db.entities.CategoryEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {

    private Long id;

    @NotBlank( message = "ISBN empty")
    @Size (min = 13, max = 13, message = "ISBN debe contener 13 carácteres")
    private String isbn;

    @NotBlank(message = "title empty")
    @Size (min = 3, max = 25, message = "Titulo debe contener entre 3 y 25 carácteres")
    private String title;

    private String author;

    @NotNull(message = "pages empty")
    private Integer pages;

    @NotNull(message = "category not selected")
    private CategoryEntity category;
}

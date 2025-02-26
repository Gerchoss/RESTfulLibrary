package com.day1.RESTfulPractice.controller.dto.response;

import com.day1.RESTfulPractice.db.entities.BookEntity;
import com.day1.RESTfulPractice.db.entities.ClientEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LibraryResponse {

    private Long id;
    private BookEntity bookEntity;
    private ClientEntity clientEntity;
    private Double rentalValue;
    private LocalDate rentalExpiration;
}

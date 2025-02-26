package com.day1.RESTfulPractice.controller.dto.request;

import com.day1.RESTfulPractice.db.entities.BookEntity;
import com.day1.RESTfulPractice.db.entities.ClientEntity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LibraryRequest {

    private Long id;

    @NotNull(message = "book not selected")
    private BookEntity bookEntity;

    @NotNull(message = "client not selected")
    private ClientEntity clientEntity;

    @NotNull(message = "miss Rental Value per day")
    private Double rentalValue;

    @NotNull(message = "Rental Expiration not selected")
    private LocalDate rentalExpiration;
}

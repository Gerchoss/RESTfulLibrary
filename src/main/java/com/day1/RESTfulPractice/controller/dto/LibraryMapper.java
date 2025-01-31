package com.day1.RESTfulPractice.controller.dto;

import com.day1.RESTfulPractice.controller.dto.request.LibraryRequest;
import com.day1.RESTfulPractice.controller.dto.response.LibraryResponse;
import com.day1.RESTfulPractice.db.entities.LibraryEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LibraryMapper {
    public LibraryEntity toEntity(LibraryRequest libraryRequest){
        LibraryEntity libraryEntity = new LibraryEntity();
        libraryEntity.setBook(libraryRequest.getBook());
        libraryEntity.setClient(libraryRequest.getClient());
        libraryEntity.setRentalExpiration(libraryRequest.getRentalExpiration());
        libraryEntity.setRentalValue(libraryRequest.getRentalValue());
        return libraryEntity;
    }

    public LibraryResponse toResponse (LibraryEntity libraryEntity){
        if (libraryEntity == null){
            return null;
        }
        return LibraryResponse.builder()
                .book(libraryEntity.getBook())
                .client(libraryEntity.getClient())
                .rentalExpiration(libraryEntity.getRentalExpiration())
                .rentalValue(libraryEntity.getRentalValue())
                .build();
    }

    public static LibraryResponse findById(LibraryEntity libraryEntity){
        return LibraryResponse.builder()
                .book(libraryEntity.getBook())
                .client(libraryEntity.getClient())
                .rentalExpiration(libraryEntity.getRentalExpiration())
                .rentalValue(libraryEntity.getRentalValue())
                .build();
    }

    public List<LibraryResponse> toResponseList(List<LibraryEntity> libraryEntity){
        return libraryEntity.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}

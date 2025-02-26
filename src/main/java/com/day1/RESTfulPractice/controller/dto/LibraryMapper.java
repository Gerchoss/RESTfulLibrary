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
        libraryEntity.setBookEntity(libraryRequest.getBookEntity());
        libraryEntity.setClientEntity(libraryRequest.getClientEntity());
        libraryEntity.setRentalExpiration(libraryRequest.getRentalExpiration());
        libraryEntity.setRentalValue(libraryRequest.getRentalValue());
        return libraryEntity;
    }

    public LibraryResponse toResponse (LibraryEntity libraryEntity){
        if (libraryEntity == null){
            return null;
        }
        return LibraryResponse.builder()
                .bookEntity(libraryEntity.getBookEntity())
                .clientEntity(libraryEntity.getClientEntity())
                .rentalExpiration(libraryEntity.getRentalExpiration())
                .rentalValue(libraryEntity.getRentalValue())
                //ver como obtener un id aca .bookEntity(libraryEntity.getBookEntity())
                .build();
    }

    //ver como llamo los datos lazy

    public static LibraryResponse findById(LibraryEntity libraryEntity){
        return LibraryResponse.builder()
                .bookEntity(libraryEntity.getBookEntity())
                .clientEntity(libraryEntity.getClientEntity())
                .rentalExpiration(libraryEntity.getRentalExpiration())
                .rentalValue(libraryEntity.getRentalValue())
                .build();
    }

    //ver por aca, aca esta el problema con el lazy del buscar todos, lo comentado seguro era lo que estaba dando problemas
    //convertir el mapper en builder
    //utilizar el mapper añadiendo los valores no traidos por el lazy


    public List<LibraryResponse> toResponseList(List<LibraryEntity> libraryEntity){
        return libraryEntity.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}

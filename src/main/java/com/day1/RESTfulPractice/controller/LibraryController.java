package com.day1.RESTfulPractice.controller;

import com.day1.RESTfulPractice.application.service.LibraryService;
import com.day1.RESTfulPractice.controller.dto.request.LibraryRequest;
import com.day1.RESTfulPractice.controller.dto.response.LibraryResponse;
import com.day1.RESTfulPractice.db.entities.LibraryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library")
@RequiredArgsConstructor
public class LibraryController {

    private final LibraryService libraryService;

    @GetMapping
    public List<LibraryResponse> getAllRental(){
        return libraryService.getAllRental();
    }

    @PostMapping
    public ResponseEntity<LibraryResponse> createRental (@RequestBody LibraryRequest libraryRequest){
        LibraryResponse libraryResponse = libraryService.createRental(libraryRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(libraryService.createRental(libraryRequest));
    }

    @GetMapping("/{id}")
    public LibraryEntity getRentalFromId (@PathVariable Long id){
        return libraryService.finishingRental(id);
    }

    @PatchMapping("/{id}")
    public LibraryEntity finishingRental (@PathVariable Long id){
        return libraryService.finishingRental(id);
    }


}

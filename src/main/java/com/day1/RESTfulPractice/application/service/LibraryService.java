package com.day1.RESTfulPractice.application.service;

import com.day1.RESTfulPractice.application.exception.BookNotFoundException;
import com.day1.RESTfulPractice.controller.dto.LibraryMapper;
import com.day1.RESTfulPractice.controller.dto.request.LibraryRequest;
import com.day1.RESTfulPractice.controller.dto.response.LibraryResponse;
import com.day1.RESTfulPractice.db.LibraryRepository;
import com.day1.RESTfulPractice.db.entities.LibraryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibraryService {

    @Autowired
    private final LibraryMapper libraryMapper;

    @Autowired
    private final LibraryRepository libraryRepository;

    @Transactional(readOnly = true)
    public List<LibraryResponse> getAllRental(){
        List<LibraryEntity> libraryEntity = libraryRepository.findAll();
        return libraryMapper.toResponseList(libraryEntity);
    }

    @Transactional
    public LibraryResponse createRental(@RequestBody LibraryRequest libraryRequest){
        LibraryEntity libraryEntity = libraryMapper.toEntity(libraryRequest);
        LibraryEntity savedEntity = libraryRepository.save(libraryEntity);
        return libraryMapper.toResponse(savedEntity);
    }

    public LibraryResponse getRentalFromId(Long id){
        return libraryRepository.findById(id)
                .map((LibraryMapper::findById))
                .orElseThrow(() -> new BookNotFoundException("RENTAL NOT FOUND"));
    }

    @Transactional
    public LibraryEntity finishingRental(@PathVariable Long id){
        LibraryEntity libraryEntity = libraryRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("RENTAL NOT FOUND"));
            libraryEntity.setDeleted(true);
            return libraryRepository.save(libraryEntity);
    }

}

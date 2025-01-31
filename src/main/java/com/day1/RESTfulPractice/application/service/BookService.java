package com.day1.RESTfulPractice.application.service;

import com.day1.RESTfulPractice.application.exception.BookNotFoundException;
import com.day1.RESTfulPractice.controller.dto.BookMapper;
import com.day1.RESTfulPractice.controller.dto.request.BookRequest;
import com.day1.RESTfulPractice.controller.dto.response.BookResponse;
import com.day1.RESTfulPractice.db.BookRepository;
import com.day1.RESTfulPractice.db.entities.BookEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookMapper bookMapper;
    private final BookRepository bookRepository;

    @Transactional(readOnly = true)
    public List<BookResponse> getAllBooks(){
        List<BookEntity> bookEntity = bookRepository.findAll();
        return bookMapper.toResponseList(bookEntity);
    }

    //rehacer según goytia con excepciones y estructura acorde (al usar mapper agrego un paso mas, se puede agregar a la clase request DTO)
    @Transactional
    public BookResponse createBook(@RequestBody BookRequest bookRequest){
        BookEntity bookEntity = bookMapper.toEntity(bookRequest);
        BookEntity savedEntity = bookRepository.save(bookEntity);
        return bookMapper.toResponse(savedEntity);
    }

    //ok segun estructura de goytia, sobra mapper, ENTENDER
    public BookResponse getBook(Long id){
        return bookRepository.findById(id)
                .map(BookMapper::findById)
                .orElseThrow(() -> new BookNotFoundException("BOOK"));

    }
}

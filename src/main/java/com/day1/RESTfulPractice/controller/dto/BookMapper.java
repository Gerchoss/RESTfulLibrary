package com.day1.RESTfulPractice.controller.dto;

import com.day1.RESTfulPractice.controller.dto.request.BookRequest;
import com.day1.RESTfulPractice.controller.dto.response.BookResponse;
import com.day1.RESTfulPractice.db.entities.BookEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class BookMapper {
    public BookEntity toEntity(BookRequest bookRequest){
        BookEntity bookEntity = new BookEntity();
        bookEntity.setIsbn(bookRequest.getIsbn());
        bookEntity.setAuthor(bookRequest.getAuthor());
        bookEntity.setTitle(bookRequest.getTitle());
        bookEntity.setPages(bookRequest.getPages());
        bookEntity.setCategory(bookRequest.getCategory());
        return bookEntity;
    }

    public BookResponse toResponse (BookEntity bookEntity){
        if (bookEntity == null){
            return null;
        }
        return BookResponse.builder()
                .isbn(bookEntity.getIsbn())
                .author(bookEntity.getAuthor())
                .title(bookEntity.getTitle())
                .pages(bookEntity.getPages())
                .category(bookEntity.getCategory())
                .build();
    }

    public List<BookResponse> toResponseList(List<BookEntity> bookEntity){
        return bookEntity.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public static BookResponse findById(BookEntity bookEntity){
        return BookResponse.builder()
                .id(bookEntity.getId())
                .isbn(bookEntity.getIsbn())
                .title(bookEntity.getTitle())
                .author(bookEntity.getAuthor())
                .pages(bookEntity.getPages())
                .category(bookEntity.getCategory())
                .build();
    }
}

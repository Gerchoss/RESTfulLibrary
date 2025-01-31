package com.day1.RESTfulPractice.application.service

import com.day1.RESTfulPractice.controller.dto.BookMapper
import com.day1.RESTfulPractice.controller.dto.request.BookRequest
import com.day1.RESTfulPractice.controller.dto.request.CategoryRequest
import com.day1.RESTfulPractice.controller.dto.response.BookResponse
import com.day1.RESTfulPractice.db.BookRepository
import com.day1.RESTfulPractice.db.entities.BookEntity
import com.day1.RESTfulPractice.db.entities.CategoryEntity
import spock.lang.Specification


class BookServiceTest extends Specification{
    BookRepository bookRepository = Mock()
    BookMapper bookMapper = Mock()

    BookService target = new BookService(bookMapper, bookRepository)

    def "creating a book with DTO with creating category"() {
        given:
        def categoryEntity = new CategoryEntity()
            categoryEntity.setId(1)
            categoryEntity.setCategoryName("Action")
        def bookRequest = new BookRequest(1, "321654987", "Caballeros", "Richard", 40, categoryEntity)
        def bookEntity = new BookEntity()
            bookEntity.setId(1)
            bookEntity.setIsbn("321654987")
            bookEntity.setTitle("Caballeros")
            bookEntity.setAuthor("Richard")
            bookEntity.setPages(40)
            bookEntity.setCategory(categoryEntity)
        def bookResponse = new BookResponse(1, "321654987", "Caballeros", "Richard", 40, categoryEntity)

        when:
        def result = target.createBook(bookRequest)

        then:
        1 * bookMapper.toEntity(bookRequest) >> bookEntity
        1 * bookRepository.save(bookEntity) >> bookEntity
        1 * bookMapper.toResponse(bookEntity) >> bookResponse

        and: "se genera un nuevo libro"
        result == bookResponse


    }
}

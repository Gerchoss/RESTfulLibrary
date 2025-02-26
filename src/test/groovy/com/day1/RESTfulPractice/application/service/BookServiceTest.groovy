package com.day1.RESTfulPractice.application.service

import com.day1.RESTfulPractice.controller.dto.BookMapper
import com.day1.RESTfulPractice.controller.dto.request.BookRequest
import com.day1.RESTfulPractice.controller.dto.response.BookResponse
import com.day1.RESTfulPractice.db.BookRepository
import com.day1.RESTfulPractice.db.entities.BookEntity
import com.day1.RESTfulPractice.db.entities.CategoryEntity
import spock.lang.Specification
import spock.lang.Subject


class BookServiceTest extends Specification{
    BookRepository bookRepository = Mock()
    BookMapper bookMapper = Mock()

    @Subject
    BookService target = new BookService(bookMapper, bookRepository)

    def "creating a book with DTO with creating category"() {
        given:
        def bookRequest = createBookRequest()
        def bookEntity = createBookEntity()
        def bookResponse = createBookResponse()

        when:
        def result = target.createBook(bookRequest)

        then:
        1 * bookMapper.toEntity(bookRequest) >> bookEntity
        1 * bookRepository.save(bookEntity) >> bookEntity
        1 * bookMapper.toResponse(bookEntity) >> bookResponse

        and: "se genera un nuevo libro con los datos correctos"
        result.id == bookResponse.id
        result.isbn == bookResponse.isbn
        result.title == bookResponse.title
        result.author == bookResponse.author
        result.pages == bookResponse.pages
        result.category.categoryName == bookResponse.category.categoryName

    }

    def "should throw exception when bookRepository fails"() {
        given:
        def bookRequest = createBookRequest()
        def bookEntity = createBookEntity()

        bookMapper.toEntity(bookRequest) >> bookEntity
        bookRepository.save(bookEntity) >> { throw new RuntimeException("Book Repository error")}

        when:
        target.createBook(bookRequest)

        then:
        def e = thrown(RuntimeException)
        e.message == "Book Repository error"
    }

    private final BookRequest createBookRequest() {
        return new BookRequest(1, "321654987", "Caballeros", "Richard", 40, createCategoryEntity())
    }

    private final BookEntity createBookEntity() {
        def bookEntity = new BookEntity()
        bookEntity.setId(1)
        bookEntity.setIsbn("321654987")
        bookEntity.setTitle("Caballeros")
        bookEntity.setAuthor("Richard")
        bookEntity.setPages(40)
        bookEntity.setCategory(createCategoryEntity())
        return bookEntity
    }

    private final BookResponse createBookResponse() {
        return new BookResponse(1, "321654987", "Caballeros", "Richard", 40, createCategoryEntity())
    }

    private final CategoryEntity createCategoryEntity() {
        def category = new CategoryEntity()
        category.setId(1)
        category.setCategoryName("Action")
        return category
    }
}

package com.day1.RESTfulPractice.application.service

import com.day1.RESTfulPractice.controller.dto.CategoryMapper
import com.day1.RESTfulPractice.controller.dto.request.CategoryRequest
import com.day1.RESTfulPractice.controller.dto.response.CategoryResponse
import com.day1.RESTfulPractice.db.CategoryRepository
import com.day1.RESTfulPractice.db.entities.CategoryEntity
import spock.lang.Specification
import spock.lang.Subject

class CategoryServiceTest extends Specification{
    CategoryRepository categoryRepository = Mock()
    CategoryMapper categoryMapper = Mock()

    @Subject
    CategoryService target = new CategoryService(categoryRepository, categoryMapper)

    def "creating a category with DTO"() {
        given:
        def categoryRequest = createCategoryRequest()
        def categoryEntity = createCategoryEntity()
        def categoryResponse = createCategoryResponse()

        when:
        def result = target.createCategory(categoryRequest)

        then:
        1 * categoryMapper.toEntity(categoryRequest) >> categoryEntity
        1 * categoryRepository.save(categoryEntity) >> categoryEntity
        1 * categoryMapper.toResponse(categoryEntity) >> categoryResponse

        and: "El resultado debe ser el esperado"
        result == categoryResponse
    }

    def "should throw exception when categoryRepository fails" (){
        given:
        def categoryRequest = createCategoryRequest()
        def categoryEntity = createCategoryEntity()

        categoryMapper.toEntity(categoryRequest) >> categoryEntity
        categoryRepository.save(categoryEntity) >> { throw new RuntimeException("Category Repository error")}

        when:
        target.createCategory(categoryRequest)

        def e = thrown(RuntimeException)
        e.message == "Category Repository error"
    }

    private final CategoryEntity createCategoryEntity() {
        def category = new CategoryEntity()
        category.setId(1)
        category.setCategoryName("Romance")
        return category
    }

    private final CategoryResponse createCategoryResponse() {
        return new CategoryResponse(1, "Romance")
    }

    private final CategoryRequest createCategoryRequest() {
        return new CategoryRequest(1, "Romance")
    }

}

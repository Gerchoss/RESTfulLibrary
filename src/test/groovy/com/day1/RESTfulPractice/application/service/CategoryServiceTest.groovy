package com.day1.RESTfulPractice.application.service

import com.day1.RESTfulPractice.controller.dto.CategoryMapper
import com.day1.RESTfulPractice.controller.dto.request.CategoryRequest
import com.day1.RESTfulPractice.controller.dto.response.CategoryResponse
import com.day1.RESTfulPractice.db.CategoryRepository
import com.day1.RESTfulPractice.db.entities.CategoryEntity
import spock.lang.Specification

class CategoryServiceTest extends Specification{
    CategoryRepository categoryRepository = Mock()
    CategoryMapper categoryMapper = Mock()

    CategoryService target = new CategoryService(categoryRepository, categoryMapper)

    def "creating a category with DTO"() {
        given:
        def categoryRequest = new CategoryRequest(1, "Romance")
        def categoryEntity = new CategoryEntity()
        categoryEntity.setId(1)
        categoryEntity.setCategoryName("Romance")
        def categoryResponse = new CategoryResponse(1, "Romance")

        when:
        def result = target.createCategory(categoryRequest)

        then:
        1 * categoryMapper.toEntity(categoryRequest) >> categoryEntity
        1 * categoryRepository.save(categoryEntity) >> categoryEntity
        1 * categoryMapper.toResponse(categoryEntity) >> categoryResponse

        and: "El resultado debe ser el esperado"
        result == categoryResponse

        then:
        1 * categoryMapper.toEntity(null, "Romance")
        and: "se genera una excepcion"
        result != categoryResponse
    }
}

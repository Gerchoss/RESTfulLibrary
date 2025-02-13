package com.day1.RESTfulPractice.db;

import com.day1.RESTfulPractice.db.entities.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    Page<CategoryRepository> findAllByCategoryNameContainingIgnoreCase(Pageable pageable, String title);
}

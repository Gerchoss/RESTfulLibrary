package com.day1.RESTfulPractice.db;

import com.day1.RESTfulPractice.db.entities.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    //Page<BookEntity> findAllByTitleContainingIgnoreCase(Pageable pageable, String title);

    //Query por el select del category. puede que jpa sea redundante
}

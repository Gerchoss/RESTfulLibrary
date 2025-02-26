package com.day1.RESTfulPractice.db;

import com.day1.RESTfulPractice.db.entities.LibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<LibraryEntity, Long> {

}

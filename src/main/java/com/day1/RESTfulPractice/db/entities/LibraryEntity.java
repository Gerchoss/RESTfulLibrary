package com.day1.RESTfulPractice.db.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "library")
@Table(name = "library")
public class LibraryEntity {

    @Id
    private Long id;

    //private BookEntity[][] library;

}

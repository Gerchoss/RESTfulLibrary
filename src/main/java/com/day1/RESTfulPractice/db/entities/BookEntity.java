package com.day1.RESTfulPractice.db.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity (name = "book")
@Table (name = "book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "isbn", nullable = false, length = 13)
    private String isbn;

    @Column (name = "title", nullable = false)
    private String title;

    @Column  (name = "author")
    private String author;

    @Column (name = "pages", nullable = false)
    private Integer pages;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
}

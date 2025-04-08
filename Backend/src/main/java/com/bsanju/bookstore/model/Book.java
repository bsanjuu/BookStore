package com.bsanju.bookstore.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private Double price;

    private LocalDateTime createdAt = LocalDateTime.now();

    public Book() {}

    public Book(String title, String author, Double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }


}

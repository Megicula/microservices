package com.example.books;
@Entity
public class Book {
    @Id
    private String bookId;
    private String bookName;
    private String author;
    private int availableCopies;
    private int totalCopies;

    // Getters and Setters
}

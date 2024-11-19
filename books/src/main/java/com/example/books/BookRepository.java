package com.example.books;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, String> {

	List<Book> findAll();
}

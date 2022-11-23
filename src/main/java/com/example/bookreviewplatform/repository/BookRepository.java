package com.example.bookreviewplatform.repository;

import com.example.bookreviewplatform.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}

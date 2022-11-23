package com.example.bookreviewplatform.controller;

import com.example.bookreviewplatform.controller.dto.BookDTO;
import com.example.bookreviewplatform.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class BookController {

    private BookService bookService;

    /**
     * Saves a new book object
     * @param bookDTO - the DTO of the book to be saved
     * @return ResponseEntity ok if it was successful Internal Server Error if not
     */
    @PostMapping(path = "add/book")
    public ResponseEntity save(@RequestBody BookDTO bookDTO){
        return bookService.save(bookDTO);
    }

    /**
     * Gets all books from the database
     * @return ResponseEntity ok if it was successful Internal Server Error if not
     */
    @GetMapping(path = "/books")
    public ResponseEntity findAll(){
        return bookService.findAll();
    }

    /**
     * Get a book by id
     * @param id id of the book
     * @return ResponseEntity ok if it was successful Internal Server Error if not
     */
    @GetMapping(path = "/book/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        return bookService.findById(id);
    }
}

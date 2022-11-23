package com.example.bookreviewplatform.service;

import com.example.bookreviewplatform.controller.dto.BookDTO;
import com.example.bookreviewplatform.mapper.BookMapper;
import com.example.bookreviewplatform.model.Book;
import com.example.bookreviewplatform.repository.BookRepository;
import com.example.bookreviewplatform.service.validator.BookValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class BookService {


    private BookRepository bookRepository;
    private BookMapper bookMapper;
    private BookValidator bookValidator;


    /**
     * Saves a new book in database
     * @param bookDTO - dto of the book to be saved
     * @return ResponseEntity ok if it was successful Internal Server Error if not
     */
    public ResponseEntity save(BookDTO bookDTO) {

        if (bookValidator.validate(bookDTO)) {
            bookRepository.save(bookMapper.convertFromDTO(bookDTO));
            return ResponseEntity.ok().build();
        }

        log.error("An error occured while inserting into the database ");
        return ResponseEntity.internalServerError().body("Booked cannot be saved in the database");
    }

    /**
     * Retrieves all books from database
     * @return ResponseEntity.ok containing a list of BookDTOs
     */
    public ResponseEntity findAll() {

        List<Book> books = bookRepository.findAll();
        List<BookDTO> bookDTOList = bookMapper.convertToDTO(books);
        return ResponseEntity.ok().body(bookDTOList);
    }

    /**
     * Finds a book by id
     * @param id id of the book
     * @return ResponseEntity ok containing the book with the id passed as parameter
     */
    public ResponseEntity findById(Long id) {

        Optional<Book> book = bookRepository.findById(id);

        if(book.isPresent()){
            BookDTO bookDTO = bookMapper.convertToDTO(book.get());
            return ResponseEntity.ok().body(bookDTO);
        }
        return ResponseEntity.internalServerError().build();

    }
}

package com.example.bookreviewplatform.mapper;

import com.example.bookreviewplatform.controller.dto.BookDTO;
import com.example.bookreviewplatform.model.Book;
import com.example.bookreviewplatform.model.User;
import com.example.bookreviewplatform.repository.UserRepository;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
@AllArgsConstructor
public class BookMapper implements ObjectMapper<Book, BookDTO> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;


    /**
     * @param bookDTO the object that contains information about the book
     * @return the new created book object
     */
    @Override
    public Book convertFromDTO(BookDTO bookDTO) {


        Book book = new Book();
        User author = userRepository.findById(bookDTO.getAuthor().getId()).get();

        book.setAuthor(author);
        book.setDescription(bookDTO.getDescription());
        book.setISBN(bookDTO.getISBN());
        book.setBookCategory(bookDTO.getCategory());
        book.setTitle(bookDTO.getTitle());
        book.setCover(bookDTO.getCover());

        return book;
    }

    /**
     * Converts from an object to DTO
     *
     * @param book object that will be converted
     * @return the mapped DTO object
     */
    @Override
    public BookDTO convertToDTO( Book book) {

        BookDTO bookDTO = new BookDTO();

        if( book.getId() != null){
            bookDTO.setId(book.getId());
        }
        bookDTO.setDescription(book.getDescription());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setISBN(book.getISBN());
        bookDTO.setCategory(book.getBookCategory());
        bookDTO.setCover(book.getCover());

        if (book.getAuthor() != null) {

            bookDTO.setAuthor(userMapper.convertToDTO(book.getAuthor()));
        }

        return bookDTO;
    }

    public List<BookDTO> convertToDTO(List<Book> books) {

        List<BookDTO> bookDTOList;
        bookDTOList = books.stream().map(book -> (convertToDTO(book))).collect(Collectors.toList());
        return bookDTOList;
    }
}


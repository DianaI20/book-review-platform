package com.example.bookreviewplatform.service;

import com.example.bookreviewplatform.model.Book;
import com.example.bookreviewplatform.model.Reader;
import com.example.bookreviewplatform.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderService {
    private UserRepository userRepository;

    public List<Book> getReadBooks(Reader reader){
        return reader.getBooksRead();
    }
}

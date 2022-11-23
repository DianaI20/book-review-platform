package com.example.bookreviewplatform.service;

import com.example.bookreviewplatform.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthorService {

    private UserRepository userRepository;
}

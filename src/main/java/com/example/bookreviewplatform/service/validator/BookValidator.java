package com.example.bookreviewplatform.service.validator;

import com.example.bookreviewplatform.controller.dto.BookDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BookValidator {

    public boolean validate(BookDTO bookDTO){
        return true;
    }
}

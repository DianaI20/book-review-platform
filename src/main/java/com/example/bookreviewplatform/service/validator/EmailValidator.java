package com.example.bookreviewplatform.service.validator;

import com.example.bookreviewplatform.service.exception.InvalidEmailException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailValidator {

    private String INVALID_EMAIL_MESSAGE = "Email %s is not valid";

    public void validate(String email) throws InvalidEmailException {

        if(email.isEmpty()){
            log.error(String.format(INVALID_EMAIL_MESSAGE, email));
            throw new InvalidEmailException("Email not valid");
        }
    }
}

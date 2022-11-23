package com.example.bookreviewplatform.service.validator;

import com.example.bookreviewplatform.service.exception.WrongPasswordException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class PasswordManager{

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final String WRONG_PASSWORD_MESSAGE = "User provided a wrong password.";

    /**
     * Checks if the password matches with the encrypted password from the database
     * @param password password not encoded
     * @param encryptedPassword encrypted password
     * @return true if the strings match, false otherwise
     */
    public boolean validate(String password, String encryptedPassword) throws WrongPasswordException {

        if(bCryptPasswordEncoder.matches(password, encryptedPassword)){
            return true;
        }else{
            log.error(WRONG_PASSWORD_MESSAGE);
            throw new WrongPasswordException(WRONG_PASSWORD_MESSAGE);
        }
    }

    /**
     *
     * @param rawPassword password
     * @return password encoded
     */
    public String encrypt(String rawPassword){
        return bCryptPasswordEncoder.encode(rawPassword);
    }
}

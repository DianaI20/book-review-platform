package com.example.bookreviewplatform.service.validator;

import com.example.bookreviewplatform.controller.dto.UserDTO;
import com.example.bookreviewplatform.mapper.UserMapper;
import com.example.bookreviewplatform.model.User;
import com.example.bookreviewplatform.repository.UserRepository;
import com.example.bookreviewplatform.service.exception.InvalidEmailException;
import com.example.bookreviewplatform.service.exception.InvalidInputException;
import com.example.bookreviewplatform.service.exception.WrongPasswordException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UserValidator {

    private EmailValidator emailValidator;
    private UserMapper userMapper;
    private UserRepository userRepository;
    private final static String USER_NOT_FOUND_MESSAGE = "User with email %s not found";
    private final static String USER_ALREADY_EXISTS = "User with email %s already exists.";

    private PasswordManager passwordManager;

    public ResponseEntity validateCredentials(String email, String password, User user) throws WrongPasswordException {

        if (user == null) {
            log.error(String.format(USER_NOT_FOUND_MESSAGE, email));
            throw new UsernameNotFoundException(String.format(USER_NOT_FOUND_MESSAGE, email));
        } else {
            if (passwordManager.validate(password, user.getPassword())) {
                return ResponseEntity.ok().body(userMapper.convertToDTO(user));
            }
            return ResponseEntity.internalServerError().build();
        }
    }

    public void  validateRegistration(String email) throws InvalidEmailException {

        emailValidator.validate(email);
        boolean userExists = (userRepository.findByEmail(email) != null);
        if (userExists) {
            log.error(String.format(USER_ALREADY_EXISTS,email));
            throw new InvalidEmailException(USER_ALREADY_EXISTS);
        }
    }

    public void validateUser(UserDTO userDTO) throws InvalidInputException, InvalidEmailException {

        if (userDTO.getPassword().length() < 10) {
            log.info("Password too short");
            throw new InvalidInputException("Password too short");
        }

        if (userDTO.getFirstName().isEmpty()) {
            log.error("Empty field: First Name");
            throw new InvalidInputException("Empty field");
        }

        if (userDTO.getLastName().isEmpty()) {
            log.error("Empty field: Last Name");
            throw new InvalidInputException("Empty field");
        }

        if (userDTO.getEmail().isEmpty()) {
            log.error("Empty field: email");
            throw new InvalidInputException("Empty field");
        }
        emailValidator.validate(userDTO.getEmail());
        log.error("All checking passed.");
        emailValidator.validate(userDTO.getEmail());

    }

}

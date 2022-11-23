package com.example.bookreviewplatform.service;

import com.example.bookreviewplatform.controller.dto.UserDTO;
import com.example.bookreviewplatform.mapper.UserMapper;
import com.example.bookreviewplatform.model.User;
import com.example.bookreviewplatform.repository.UserRepository;
import com.example.bookreviewplatform.service.exception.InvalidEmailException;
import com.example.bookreviewplatform.service.exception.InvalidInputException;
import com.example.bookreviewplatform.service.exception.WrongPasswordException;
import com.example.bookreviewplatform.service.validator.PasswordManager;
import com.example.bookreviewplatform.service.validator.UserValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {


    private UserRepository userRepository;
    private final PasswordManager passwordManager;
    private UserValidator userValidator;
    private final UserMapper userMapper;
    private final String USER_REGISTERED = "User with email %s has been registered successfully";

    @Override
    public User loadUserByUsername(String email) throws UsernameNotFoundException {
        return null;
    }

    /**
     * @param email    user's email
     * @param password user's password
     * @return user that matches thee email and password
     * @throws UsernameNotFoundException
     * @throws WrongPasswordException
     */
    public ResponseEntity findByEmailAndPassword(String email, String password)
            throws UsernameNotFoundException, WrongPasswordException {

        User user = userRepository.findByEmail(email);
        return userValidator.validateCredentials(email, password, user);
    }

    /**
     * @param user user to be inserted
     * @return ResponseEntity.ok if the user was inserted successfully
     */
    public ResponseEntity save(User user) {

        user.setPassword(passwordManager.encrypt(user.getPassword()));
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void login(String username, String password) {
    }

    public ResponseEntity register(UserDTO userDTO) {

        try {
            userValidator.validateUser(userDTO);
        } catch (InvalidInputException | InvalidEmailException e) {
            return ResponseEntity.internalServerError().body("Something went wrong while validating the credentials.");
        }
        log.info(String.format(USER_REGISTERED, userDTO.getEmail()));
        userRepository.save(userMapper.convertFromDTO(userDTO));

        return ResponseEntity.ok().build();
    }
}

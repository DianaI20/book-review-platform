package com.example.bookreviewplatform.controller;


import com.example.bookreviewplatform.service.UserService;
import com.example.bookreviewplatform.service.exception.WrongPasswordException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/login")
public class LoginController {


    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity login(@RequestParam("email") String email, @RequestParam String password) {

        try {
            return userService.findByEmailAndPassword(email, password);
        } catch (WrongPasswordException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        } catch (UsernameNotFoundException f) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}


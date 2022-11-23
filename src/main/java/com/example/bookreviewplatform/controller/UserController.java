package com.example.bookreviewplatform.controller;

import com.example.bookreviewplatform.controller.dto.UserDTO;
import com.example.bookreviewplatform.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private UserService userService;

    /**
     * Register
     * @param userDTO DTO for the user object
     * @return ResponseEntity ok if the user was registered, internal server error otherwise
     */
    @PostMapping(path = "/register")
    public ResponseEntity register(@RequestBody UserDTO userDTO){
        return userService.register(userDTO);
    }

    public ResponseEntity login(String username, String password){
        userService.login(username, password);
        return ResponseEntity.ok().build();
    }

}

package com.example.bookreviewplatform.controller.dto;


import com.example.bookreviewplatform.model.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {

    private final Long id;
    private final String email;
    private final String firstName;
    private final String lastName;
    private  String password;
    private final UserType type;
    private final String profilePicture;
    private final String description;

}

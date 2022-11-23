package com.example.bookreviewplatform.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ReviewDTO {

    private Long id;
    private String subject;
    private String details;
    private BookDTO book;
    private UserDTO author;
}

package com.example.bookreviewplatform.controller.dto;

import com.example.bookreviewplatform.model.BookCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private Long id;
    private String title;
    private String cover;
    private String description;
    private String ISBN;
    private BookCategory category;
    private UserDTO author;

}

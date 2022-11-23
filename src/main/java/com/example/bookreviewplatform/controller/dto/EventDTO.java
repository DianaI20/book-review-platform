package com.example.bookreviewplatform.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO {

    private Long id;
    private String title;
    private String location;
    private String cover;
    private LocalDate date;
    private LocalTime startingTime;
    private LocalTime endingTime;
    private String description;
    private UserDTO author;
    private List<UserDTO> participants;
}

package com.example.bookreviewplatform.controller;

import com.example.bookreviewplatform.controller.dto.EventDTO;
import com.example.bookreviewplatform.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    private EventService eventService;

    /**
     * Add a new event
     * @param eventDTO DTO of the event
     * @return ResponseEntity ok if the event was added, Internal Server Error otherwise
     */
    @PostMapping(path = "/add/event")
    private ResponseEntity addEvent(@RequestBody EventDTO eventDTO){
        return eventService.save(eventDTO);
    }

    /**
     * Find all events
     * @return ResponseEntity ok with all events as a body, Internal Server Error otherwise
     */
    @GetMapping(path = "/events")
    private ResponseEntity findAll(){
        return eventService.findAll();
    }
}+

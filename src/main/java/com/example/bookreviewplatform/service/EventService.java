package com.example.bookreviewplatform.service;

import com.example.bookreviewplatform.controller.dto.EventDTO;
import com.example.bookreviewplatform.mapper.EventMapper;
import com.example.bookreviewplatform.model.Event;
import com.example.bookreviewplatform.repository.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EventService {

    private EventRepository eventRepository;
    private EventMapper eventMapper;

    public ResponseEntity save(EventDTO eventDTO) {

        Event event = eventMapper.convertFromDTO(eventDTO);
        eventRepository.save(event);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity findAll() {

        List<Event> eventList = eventRepository.findAll();
        return ResponseEntity.ok().body(eventMapper.convertToDTO(eventList));
    }
}

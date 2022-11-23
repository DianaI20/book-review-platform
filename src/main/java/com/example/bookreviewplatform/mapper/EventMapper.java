package com.example.bookreviewplatform.mapper;


import com.example.bookreviewplatform.controller.dto.EventDTO;
import com.example.bookreviewplatform.controller.dto.UserDTO;
import com.example.bookreviewplatform.model.Event;
import com.example.bookreviewplatform.model.User;
import com.example.bookreviewplatform.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EventMapper implements ObjectMapper<Event, EventDTO> {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRepository userRepository;

    @Override
    public Event convertFromDTO(EventDTO eventDTO) {

        Event event = new Event();
        User author = userMapper.convertFromDTO(eventDTO.getAuthor());

        event.setAuthor(author);
        event.setDate(event.getDate());
        event.setStartingTime(eventDTO.getStartingTime());
        event.setEndingTime(eventDTO.getEndingTime());
        event.setDescription(eventDTO.getDescription());
        event.setLocation(eventDTO.getLocation());

        return event;
    }

    @Override
    public EventDTO convertToDTO(Event event) {

        EventDTO eventDTO = new EventDTO();
        UserDTO author = userMapper.convertToDTO(event.getAuthor());

        eventDTO.setAuthor(author);

        return eventDTO;
    }

    public List<EventDTO> convertToDTO(List<Event> eventList) {

        List<EventDTO> eventDTOList = eventList.stream().map(e -> convertToDTO(e)).collect(Collectors.toList());

        return eventDTOList;
    }
}

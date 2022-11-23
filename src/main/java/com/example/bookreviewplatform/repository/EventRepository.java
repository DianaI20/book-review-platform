package com.example.bookreviewplatform.repository;

import com.example.bookreviewplatform.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}

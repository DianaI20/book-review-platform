package com.example.bookreviewplatform.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.w3c.dom.Text;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "events")
@Getter
@Setter
public class Event {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User author;

    @ManyToMany
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(name = "event_participants",
            joinColumns = @JoinColumn(name = "id", insertable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private List<Reader> participants;

    @Column(name = "starting_date")
    private LocalDate date;
    private LocalTime startingTime;
    private LocalTime endingTime;
    private String location;
    private String description;
    @Column(length = 500000)
    private String cover;



}

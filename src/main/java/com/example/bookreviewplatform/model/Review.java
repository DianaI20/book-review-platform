package com.example.bookreviewplatform.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
@Getter
@Setter
public class Review {

    @Id
    @SequenceGenerator(name = "seq",
            sequenceName = "seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;


    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    private String details;
    private String subject;

}

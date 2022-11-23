package com.example.bookreviewplatform.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ISBN;
    private String title;
    private String description;
    private String cover;

    @Enumerated(EnumType.STRING)
    private BookCategory bookCategory;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @ManyToMany
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(name = "read_books",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "reader_id"))
    private List<Reader> readers;

    @OneToMany(mappedBy = "book")
    private List<Review> reviews;


}

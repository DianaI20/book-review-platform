package com.example.bookreviewplatform.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Author extends User {

    @OneToMany(mappedBy = "author")
    private List<Book> writtenBooks;

    @OneToMany(mappedBy = "author")
    private List<Event>events;

    public Author(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password, UserType.AUTHOR);

    }

    public Author() {

    }
}

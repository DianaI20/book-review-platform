package com.example.bookreviewplatform.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Reader extends User{

    @ManyToMany
    private List<Book> booksRead;

}

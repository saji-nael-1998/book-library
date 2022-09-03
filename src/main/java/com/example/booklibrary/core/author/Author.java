package com.example.booklibrary.core.author;

import com.example.booklibrary.base.BaseEntity;
import com.example.booklibrary.core.book.Book;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Data
public class Author extends BaseEntity<Long> {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private LocalDate birthdate;
    @Column(nullable = false)
    private String bio;
    @OneToMany(mappedBy = "author")
    @JsonIgnore
    private Set<Book> books = new HashSet<>();
}

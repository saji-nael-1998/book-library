package com.example.booklibrary.core.author.web;

import com.example.booklibrary.core.book.Book;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@ToString
public class AuthorDTO {
    private String name;
    private LocalDate birthdate;
    private String bio;
    private Set<Book> books=new HashSet<>();
}

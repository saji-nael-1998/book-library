package com.example.booklibrary.core.book;

import com.example.booklibrary.base.BaseEntity;
import com.example.booklibrary.core.author.Author;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
public class Book extends BaseEntity<Long> {
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String publishYear;
    private String description;
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;
}

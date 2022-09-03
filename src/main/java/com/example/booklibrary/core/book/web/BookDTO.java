package com.example.booklibrary.core.book.web;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
public class BookDTO {
    private Long authorId;
    private String title;
    private String publishYear;
    private String description;
}

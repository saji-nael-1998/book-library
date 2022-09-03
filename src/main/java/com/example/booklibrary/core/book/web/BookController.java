package com.example.booklibrary.core.book.web;

import com.example.booklibrary.core.book.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok(bookService.create(bookDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.read(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.delete(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok(bookService.update(id, bookDTO));
    }

    @GetMapping("/findByAuthor")
    public ResponseEntity<?> findByAuthor(@RequestParam Long authorId) {
        return ResponseEntity.ok(bookService.findByAuthor(authorId));
    }
}

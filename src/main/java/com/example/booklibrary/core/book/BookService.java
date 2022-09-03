package com.example.booklibrary.core.book;

import com.example.booklibrary.ApiError.EntityNotFoundException;
import com.example.booklibrary.core.author.Author;
import com.example.booklibrary.core.author.AuthorRepo;
import com.example.booklibrary.core.book.web.BookDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;

@Service
public class BookService {

    private final BookRepo bookRepo;

    private final AuthorRepo authorRepo;

    public BookService(BookRepo bookRepo, AuthorRepo authorRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
    }

    public Book create(BookDTO bookDTO) {
        Book book = new Book();
        prepare(book, bookDTO);
        return bookRepo.save(book);
    }

    public Book read(Long id) {
        return bookRepo.findById(id).filter(b -> !b.isDeleted()).orElseThrow(EntityNotFoundException::new);
    }

    public Book update(Long id, BookDTO bookDTO) {
        Book book = read(id);
        prepare(book, bookDTO);
        return bookRepo.save(book);
    }

    public Book delete(Long id) {
        Book book = read(id);
        book.setDeleted(true);
        return bookRepo.save(book);
    }

    public Collection<Book> findByAuthor(Long authorId) {
        Author author = findAuthor(authorId);
        return bookRepo.findByAuthor(author);
    }

    public void prepare(Book book, BookDTO bookDTO) {
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(findAuthor(bookDTO.getAuthorId()));
        book.setPublishYear(bookDTO.getPublishYear());
        book.setDescription(bookDTO.getDescription());
        if (book.getCreatedDate() == null)
            book.setCreatedDate(LocalDateTime.now());
    }

    public Author findAuthor(Long authorId) {
        return authorRepo.findById(authorId).filter(a -> !a.isDeleted()).orElseThrow(() -> new EntityNotFoundException(authorId));
    }
}

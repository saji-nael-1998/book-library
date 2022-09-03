package com.example.booklibrary.core.author;

import com.example.booklibrary.ApiError.EntityNotFoundException;
import com.example.booklibrary.core.author.web.AuthorDTO;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
@Service
public class AuthorService {
    private final AuthorRepo authorRepo;

    public AuthorService(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    public Author create(AuthorDTO req) {
        Author author = new Author();
        prepare(author, req);
        return authorRepo.save(author);
    }

    public Author read(Long id) {
        return authorRepo.findById(id).filter(author -> !author.isDeleted()).orElseThrow(EntityNotFoundException::new);
    }

    public Author delete(Long id) {
        Author author = read(id);
        author.setDeleted(true);
        return authorRepo.save(author);
    }

    public Author update(Long id, AuthorDTO authorDTO) {
        Author author = read(id);
        prepare(author, authorDTO);
        return authorRepo.save(author);
    }

    public void prepare(Author author, AuthorDTO req) {
        author.setName(req.getName().toLowerCase());
        author.setBirthdate(req.getBirthdate());
        author.setBio(req.getBio());
        author.setBooks(req.getBooks());
        if (author.getCreatedDate() == null)
            author.setCreatedDate(LocalDateTime.now());
    }
}

package com.example.booklibrary.core.book;

import com.example.booklibrary.core.author.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Collection;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE b.author=?1 AND b.isDeleted=false")
    Collection<Book> findByAuthor(Author author);
}

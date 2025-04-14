package com.fmi.master.repository;

import com.fmi.master.models.Book;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.Map;

@Repository
public class BookRepository {
    @Getter
    private final Map<String, Book> books = new LinkedHashMap<>();
    private long latestId = 5L;

    @PostConstruct
    public void populateBooks() {
        books.put("Clean Code", new Book(1L, "Clean Code", "Robert C. Martin", 464));
        books.put("Effective Java", new Book(2L, "Effective Java", "Joshua Bloch", 416));
        books.put("Design Patterns", new Book(3L, "Design Patterns", "Erich Gamma et al.", 395));
        books.put("The Pragmatic Programmer", new Book(4L, "The Pragmatic Programmer", "Andrew Hunt, David Thomas", 352));
        books.put("Refactoring", new Book(5L, "Refactoring", "Martin Fowler", 448));
    }


    public Book createBook(Book book) {
        book.setId(++latestId);
        books.put(book.getTitle(), book);

        return books.get(book.getTitle());
    }

    public Book updateTitle(String oldTitle, Book book) {
        books.remove(oldTitle);
        books.put(book.getTitle(), book);
        return book;
    }

    public void deleteBook(String title) {
        books.remove(title);
    }
}

package com.fmi.master.services;


import java.util.List;
import java.util.Optional;

import com.fmi.master.models.Book;
import com.fmi.master.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class BookService
{
    private final BookRepository bookRepository;


    @Autowired
    public BookService(final BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    public Book createBook(String title, String author, int pages) {
        Book book = Book.builder()
                .title(title)
                .author(author)
                .pages(pages)
                .build();

        return this.bookRepository.createBook(book);
    }


    public Book getBookByName(final String name)
    {
        return this.bookRepository.getBooks().get(name);
    }


    public List<Book> getAllBooks()
    {
        return this.bookRepository.getBooks().values().stream().toList();
    }

    public Book updateBook(long id, String title, String author, int pages) {
        Optional<Book> bookOptional = getAllBooks().stream().filter(b -> b.getId() == id).findFirst();
        if (bookOptional.isEmpty()) {
            throw new IllegalArgumentException("Book not found");
        }

        Book book = bookOptional.get();
        String oldTitle = book.getTitle();

        return this.bookRepository.updateTitle(oldTitle, new Book(id, title, author, pages));
    }

    public String deleteBook(Long id) {
        Optional<Book> bookOptional = getAllBooks().stream().filter(b -> b.getId() == id).findFirst();
        if (bookOptional.isEmpty()) {
            return "Book not found";
        }
        String title = bookOptional.get().getTitle();
        this.bookRepository.deleteBook(title);
        return "Book deleted successfully!";
    }
}

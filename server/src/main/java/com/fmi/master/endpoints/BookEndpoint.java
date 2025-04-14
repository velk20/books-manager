package com.fmi.master.endpoints;


import com.fmi.master.models.*;
import com.fmi.master.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;


@Endpoint
public class BookEndpoint
{

    private static final String NAMESPACE = "http://books";

    private final BookService bookService;


    @Autowired
    public BookEndpoint(final BookService bookService)
    {
        this.bookService = bookService;
    }


    @PayloadRoot(namespace = NAMESPACE, localPart = "getBookRequest")
    @ResponsePayload
    public GetBookResponse getBookRequest(@RequestPayload final GetBookRequest bookRequest)
    {
        final GetBookResponse getBookResponse = new GetBookResponse();

        final Book bookByTitle = this.bookService.getBookByName(bookRequest.getTitle());
        getBookResponse.setBook(bookByTitle);

        return getBookResponse;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "createBookRequest")
    @ResponsePayload
    public CreateBookResponse createBookRequest(@RequestPayload final CreateBookRequest request)
    {
        final CreateBookResponse createBookResponse = new CreateBookResponse();

        Book book = this.bookService.createBook(request.getTitle(), request.getAuthor(), request.getPages());
        createBookResponse.setBook(book);
        return createBookResponse;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "getAllBooksRequest")
    @ResponsePayload
    public GetAllBooksResponse getAllBooksResponse(@RequestPayload final GetAllBooksRequest request)
    {
        final GetAllBooksResponse response = new GetAllBooksResponse();

        List<Book> books = this.bookService.getAllBooks();
        response.setBooks(books);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "updateBookRequest")
    @ResponsePayload
    public UpdateBookResponse updateBookRequest(@RequestPayload final UpdateBookRequest request)
    {
        final UpdateBookResponse updateBookResponse = new UpdateBookResponse();

        Book book = this.bookService.updateBook(request.getId(), request.getTitle(), request.getAuthor(), request.getPages());
        updateBookResponse.setBook(book);
        return updateBookResponse;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "deleteBookRequest")
    @ResponsePayload
    public DeleteBookResponse deleteBookRequest(@RequestPayload final DeleteBookRequest request)
    {
        final DeleteBookResponse deleteBookResponse = new DeleteBookResponse();

        String message = this.bookService.deleteBook(request.getId());
        deleteBookResponse.setMessage(message);
        return deleteBookResponse;
    }
}

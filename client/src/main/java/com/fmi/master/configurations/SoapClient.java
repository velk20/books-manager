package com.fmi.master.configurations;


import com.fmi.master.models.*;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;


@Component
public class SoapClient extends WebServiceGatewaySupport
{

    public GetBookResponse getBook(final String title)
    {
        final GetBookRequest request = new GetBookRequest();
        request.setTitle(title);

        return (GetBookResponse) getWebServiceTemplate()
                        .marshalSendAndReceive("http://localhost:8091/ws", request,
                                               new SoapActionCallback("http://books/getBookRequest"));
    }

    public GetAllBooksResponse getAllBooks()
    {
        final GetAllBooksRequest request = new GetAllBooksRequest();

        return (GetAllBooksResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8091/ws", request,
                        new SoapActionCallback("http://books/getAllBooksRequest"));
    }

    public CreateBookResponse createBook(final String title, final String author, final int pages)
    {
        final CreateBookRequest request = new CreateBookRequest();
        request.setTitle(title);
        request.setAuthor(author);
        request.setPages(pages);

        return (CreateBookResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8091/ws", request,
                        new SoapActionCallback("http://books/createBookRequest"));
    }

    public UpdateBookResponse updateBook(final Long id, final String title, final String author, final int pages) {
        final UpdateBookRequest request = new UpdateBookRequest();
        request.setId(id);
        request.setTitle(title);
        request.setAuthor(author);
        request.setPages(pages);

        return (UpdateBookResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8091/ws", request,
                        new SoapActionCallback("http://books/updateBookRequest"));
    }

    public DeleteBookResponse deleteBook(final Long id) {
        final DeleteBookRequest request = new DeleteBookRequest();
        request.setId(id);

        return (DeleteBookResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8091/ws", request,
                        new SoapActionCallback("http://books/deleteBookRequest"));
    }
}

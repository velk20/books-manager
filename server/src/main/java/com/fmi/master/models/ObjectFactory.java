package com.fmi.master.models;


import jakarta.xml.bind.annotation.XmlRegistry;


@XmlRegistry
public class ObjectFactory
{
    public ObjectFactory() {}

    public GetAllBooksRequest createGetAllBooksRequest(){return new GetAllBooksRequest();}
    public GetAllBooksResponse createGetAllBooksResponse(){return new GetAllBooksResponse();}

    public CreateBookResponse createCreateBookResponse(){return new CreateBookResponse();}
    public CreateBookRequest createCreateBookRequest(){return new CreateBookRequest();}

    public GetBookRequest createGetBookRequest()
    {
        return new GetBookRequest();
    }
    public GetBookResponse createGetBookResponse()
    {
        return new GetBookResponse();
    }

    public UpdateBookResponse createUpdateBookResponse(){return new UpdateBookResponse();}
    public UpdateBookRequest createUpdateBookRequest(){return new UpdateBookRequest();}

    public DeleteBookResponse createDeleteBookResponse(){return new DeleteBookResponse();}
    public DeleteBookRequest createDeleteBookRequest(){return new DeleteBookRequest();}

    public Book createBook()
    {
        return new Book();
    }

}

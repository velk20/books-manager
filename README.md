# Books Management System

## Currently the application has the capability to:
   - retrieve a book by title
   - retrieve all books
   - create a book
   - update a book by title
   - delete a book by id

### SOAP Server Documentation
The server can be started by running the main method located in the 'ServerApplication' class  
or by running 'mvn spring-boot:run'.  
The server is set to run at port **8091**

### WSDL Extraction  
To retrieve the WSDL file from the service, you can use the following URL:
http://localhost:8091/ws/books.wsdl

### SOAP Client Documentation
The client can be started by running the main method located in the 'ClientApplication' class
or by running 'mvn spring-boot:run'.

After the client is started, you will be promoted to enter an option or type 'Exit' to exit the application.

Note: You can still send requests using the service only with the following way:
1. In the resources folder of the server you will find the following example request:
   - get-book-request.xml
   - get-all-books-request.xml
   - update-book-request.xml
   - create-book-request.xml
   - delete-book-request.xml
2. Send the request using Postman or similar and set the method to POST,  
   the Content-Type to text/xml and the body to be of type raw XML

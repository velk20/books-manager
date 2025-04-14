package com.fmi.master.presenters;


import java.util.Scanner;

import com.fmi.master.configurations.SoapClient;
import com.fmi.master.models.*;
import com.jakewharton.fliptables.FlipTable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class BookPresenter {
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_RESET = "\u001B[0m";
    private final SoapClient soapClient;

    public BookPresenter(final SoapClient soapClient) {
        this.soapClient = soapClient;
    }

    @Bean
    public CommandLineRunner lookup(final BookPresenter bookPresenter) {
        return args -> bookPresenter.present();
    }


    private void present() {
        final Scanner scanner = new Scanner(System.in);
        String option;

        do {
            System.out.println("\n--- Book Console Client ---");
            System.out.println("1. Get book by title");
            System.out.println("2. Get all books");
            System.out.println("3. Create a book");
            System.out.println("4. Update book by id");
            System.out.println("5. Delete book by id");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            option = scanner.nextLine();

            switch (option) {
                case "1":
                    getBookByTitle(scanner);
                    break;

                case "2":
                    getAllBooks();
                    break;

                case "3":
                    createBook(scanner);
                    break;

                case "4":
                    updateBook(scanner);
                    break;

                case "5":
                    deleteBook(scanner);
                    break;

                case "6":
                    System.out.println(ANSI_BLUE + "Shutting down..." + ANSI_RESET);
                    break;

                default:
                    System.out.println(createErrorMessage("Invalid option. Please try again."));
            }

        } while (!option.equals("6"));

        scanner.close();
        System.exit(0);
    }

    private void deleteBook(Scanner scanner) {
        long bookId = getIntInput(scanner, "book id");
        try {
            DeleteBookResponse deleteBookResponse = soapClient.deleteBook(bookId);
            System.out.println(createSuccessMessage(deleteBookResponse.getMessage() + "\n"));
        } catch (Exception e) {
            System.out.println(createErrorMessage("Error: " + e.getMessage()));
        }
    }

    private void updateBook(Scanner scanner) {
        long bookId = getIntInput(scanner, "book id");
        String title = getStringInput(scanner, "book title");
        String author = getStringInput(scanner, "author name");
        int pages = getIntInput(scanner, "number of pages");
        try {
            UpdateBookResponse updateBookResponse = soapClient.updateBook(bookId, title, author, pages);
            System.out.println(createSuccessMessage("Book updated successfully: \n") + updateBookResponse.getBook());
        } catch (Exception e) {
            System.out.println(createErrorMessage("Error: " + e.getMessage()));
        }
    }

    private void getAllBooks() {
        try {
            GetAllBooksResponse allBooksResponse = soapClient.getAllBooks();
            if (allBooksResponse != null
                    && allBooksResponse.getBooks() != null
                    && !allBooksResponse.getBooks().isEmpty()) {
                String[][] data = allBooksResponse.getBooks().stream()
                        .map(book -> new String[]{
                                String.valueOf(book.getId()),
                                book.getTitle(),
                                book.getAuthor(),
                                String.valueOf(book.getPages())
                        })
                        .toArray(String[][]::new);

                String[] headers = Book.getHeaders();

                System.out.println(FlipTable.of(headers, data));
            } else {
                System.out.println(createErrorMessage("No books found."));
            }
        } catch (Exception e) {
            System.out.println(createErrorMessage("Error: " + e.getMessage()));
        }
    }

    private void getBookByTitle(Scanner scanner) {
        System.out.print("Enter the title of the book: ");
        String bookTitle = scanner.nextLine();
        try {
            GetBookResponse response = soapClient.getBook(bookTitle);
            if (response != null && response.getBook() != null) {
                System.out.println(response.getBook());
            } else {
                System.out.println(createErrorMessage(String.format("Book with title [%s] not found.", bookTitle)));
            }
        } catch (Exception e) {
            System.out.println(createErrorMessage("Error: " + e.getMessage()));
        }
    }

    private void createBook(Scanner scanner) {
        String title = getStringInput(scanner, "book title");
        String author = getStringInput(scanner, "author name");
        int pages = getIntInput(scanner, "number of pages");
        try {
            CreateBookResponse createResponse = soapClient.createBook(title, author, pages);
            System.out.println(createSuccessMessage("Book created successfully: \n") + createResponse.getBook());
        } catch (Exception e) {
            System.out.println(createErrorMessage("Error: " + e.getMessage()));
        }
    }

    private String getStringInput(Scanner scanner, String input) {
        String userInput;
        do {
            System.out.print("Enter " + input + ": ");
            userInput = scanner.nextLine().trim();
            if (userInput.isEmpty()) {
                System.out.println(createErrorMessage(input + " cannot be empty. Please try again."));
            }
        } while (userInput.isEmpty());
        return userInput;
    }

    private int getIntInput(Scanner scanner, String input) {
        int number;
        while (true) {
            System.out.print("Enter " + input + ": ");
            String userInput = scanner.nextLine().trim();

            if (userInput.isEmpty()) {
                System.out.println(createErrorMessage(input + " cannot be empty. Please try again."));
                continue;
            }

            try {
                number = Integer.parseInt(userInput);
                return number;
            } catch (NumberFormatException e) {
                System.out.println(createErrorMessage("Invalid number. Please enter a valid integer."));
            }
        }
    }

    private String createSuccessMessage(String message) {
        return ANSI_GREEN + message + ANSI_RESET;
    }

    private String createErrorMessage(final String message) {
        return ANSI_RED + message + ANSI_RESET;
    }

}
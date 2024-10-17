import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.SimpleFormatter;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Library library = getLibrary();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("---");
            System.out.println("| Welcome to Brigid's Library");
            System.out.println("---");
            System.out.println("| 1 - List all books");
            System.out.println("| 2 - List available books");
            System.out.println("| 3 - List all authors");
            System.out.println("| 4 - Register author");
            System.out.println("| 5 - Loan book");
            System.out.println("| 6 - Return book");
            System.out.println("| 7 - List all loans");
            System.out.println("| 8 - List active loans");
            System.out.println("| 9 - Leave");

            System.out.println("\n Please enter your choice.");
            int answer = scanner.nextInt();

            int [] options = {1, 2, 3, 4, 5, 6, 7, 8, 9};

            boolean isValid = false;
            for (int option : options) {
                if (option == answer) {
                    isValid = true;
                    break;
                }
            }

            if (!isValid) {
                System.out.println("Invalid option! Please provide a valid option.");
                answer = scanner.nextInt();
            }

            if (answer == 9) {
                System.out.println("Thank you for using Brigid's Library, see you next time!");
                break;
            }
            // List all books
            if (answer == 1) {
                System.out.println("Here's a list of all books \n");

                for (int i = 0; i < library.getBooks().size(); i++) {
                    System.out.println("| " + (i + 1) + " - " + library.getBooks().get(i).getTitle());
                }

                System.out.println("\n What you want to do next?");
                answer = scanner.nextInt();
            }
            // List available books
            if (answer == 2) {
                System.out.println("Here's a list of all available books \n");

                for (int i = 0; i < library.getBooksAvailable().size(); i++) {
                    System.out.println("| " + (i + 1) + " - " + library.getBooksAvailable().get(i).getTitle());
                }

                System.out.println("\n What you want to do next?");
                answer = scanner.nextInt();
            }
            // List authors
            if (answer == 3) {
                System.out.println("Here's a list of all authors \n");

                for (int i = 0; i < library.getAuthors().size(); i++) {
                    System.out.println("| " + (i + 1) + " - " + library.getAuthors().get(i).getName());
                }

                System.out.println("\n What you want to do next?");
                answer = scanner.nextInt();
            }
            // Register author
            if (answer == 4) {
                System.out.println("Enter the author firstname");
                String authorFirstName = scanner.next();
                System.out.println("Enter the author lastname");
                String authorLastname = scanner.next();

                String authorName = String.format("%s %s", authorFirstName, authorLastname);

                Author newAuthor = new Author(authorName, new Date());
                library.addAuthor(newAuthor);

                System.out.println("Author " + authorName + " registered successfully!");

                System.out.println("What you want to do next?");
                answer = scanner.nextInt();
            }
            // Loan book
            if (answer == 5) {
                System.out.println("Here's a list of all available books \n");

                for (int i = 0; i < library.getBooksAvailable().size(); i++) {
                    System.out.println("| " + (i + 1) + " - " + library.getBooksAvailable().get(i).getTitle());
                }

                System.out.println("\nEnter the code of the book you want to loan.");
                int bookIndex = scanner.nextInt();

                Book selectedBook = library.getBooksAvailable().get(bookIndex - 1);

                System.out.println("What is your firstname?");
                String username = scanner.next();

                System.out.println("What is your email address");
                String email = scanner.next();

                Customer customer = new Customer(username, email, new Date());

                try {
                    library.loanBook(selectedBook, customer);
                    System.out.println("Book " + selectedBook.getTitle() + " loan successfully!");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    System.out.println("What you want to do next?");
                    answer = scanner.nextInt();
                }
            }
            // Return book
            if (answer == 6) {
                System.out.println("Ok, what is your email? \n");
                String userEmail = scanner.next();

                try {
                    library.returnBook(userEmail);
                    System.out.println("Book returned successfully!");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    System.out.println("What you want to do next?");
                    answer = scanner.nextInt();
                }
            }
            // List all loans
            if (answer == 7) {
                System.out.println("Here's a list of all loans \n");

                for (int i = 0; i < library.getLoans().size(); i++) {
                    System.out.println("| " + (i + 1) + " - " + library.getLoans().get(i).getBook().getTitle() + "loan by" + library.getActiveLoans().get(i).getCustomer().getName());
                }

                System.out.println("\n What you want to do next?");
                answer = scanner.nextInt();
            }
            // List active loans
            if (answer == 8) {
                System.out.println("Here's a list of all loans \n");

                for (int i = 0; i < library.getActiveLoans().size(); i++) {
                    System.out.println("| " + (i + 1) + " - " + library.getActiveLoans().get(i).getBook().getTitle() + " loan by " + library.getActiveLoans().get(i).getCustomer().getName());
                }

                System.out.println("\n What you want to do next?");
                answer = scanner.nextInt();
            }

        }

        // scanner.close();
    }

    private static Library getLibrary() {
        Library library = new Library("Brigid's Library");

        // Populate library - Authors
        Author author1 = new Author("J.R.R Tolkien", new Date());
        library.addAuthor(author1);
        Author author2 = new Author("Phillip K. Dick", new Date());
        library.addAuthor(author2);
        // Populate library - Books
        Book book1 = new Book("Hobbits", author1);
        library.addBook(book1);
        Book book2 = new Book("Do droids dreams with electric sheep?",  author2);
        library.addBook(book2);
        return library;
    }
}
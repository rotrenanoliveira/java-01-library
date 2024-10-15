import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.SimpleFormatter;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Library library = new Library("Ramund's Library");

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

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Do you like to see the available books? (y/n)");
            String answer = scanner.next().toLowerCase();

            if (!answer.equals("y") && !answer.equals("n")) {
                System.out.println("Invalid option! Please answer with 'y' or 'n'.");
                answer = scanner.next().toLowerCase();
            }

            if (answer.equals("n")) {
                System.out.println("Thank you for using Ramund's Library, see you next time!");
                break;
            }

            List<Book> availableBooks = library.getBooksAvailable();

            if (availableBooks.isEmpty()) {
                System.out.println("I'm sorry, we ran out of a books!");
                break;
            }

            for (int i = 0; i < availableBooks.size(); i++) {
                System.out.println((i + 1) + ") " + availableBooks.get(i).getTitle());
            }

            System.out.println("Enter the ID of the book you wish to borrow:");
            int bookIndex = scanner.nextInt();
            scanner.nextLine();

            if (bookIndex > availableBooks.size()) {
                System.out.println("Invalid option! Please provide a valid book ID.");
                bookIndex = scanner.nextInt();
            }

            Book bookChosen = availableBooks.get(bookIndex - 1);

            if (!bookChosen.isAvailable()) {
                System.out.println("I'm sorry this book is not available.");
            }
        }

        scanner.close();
    }
}
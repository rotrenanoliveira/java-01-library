import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private List<Book> books = new ArrayList<Book>();
    private List<Author> authors = new ArrayList<Author>();
    private List<Loan> loans = new ArrayList<Loan>();

    public Library(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public List<Book> getBooks() {
        return this.books;
    }

    public List<Book> getBooksAvailable() {
        return this.books.stream().filter(Book::isAvailable).toList();
    }

    public List<Book> getBooksByAuthor(String authorName) {
        return this.books.stream().filter(book -> book.getAuthor().getName().equals(authorName)).toList();
    }

    public List<Book> getBooksByTitle(String title) {
        return this.books.stream().filter(book -> book.getTitle().equals(title)).toList();
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void loanBook(Book book, Customer customer) throws Exception {
        if (!book.isAvailable()) {
            throw new Exception("Book is not available.");
        }

        Loan loan = new Loan(book, customer);
        loans.add(loan);

        book.setAvailable(false);
    }
}

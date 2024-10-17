import java.util.Date;
import java.util.UUID;

public class Loan {
    private final UUID id = UUID.randomUUID();
    private final Book book;
    private final Customer customer;
    private final Date loanDate;
    private Date returnDate;
    private boolean isActive;

    public Loan(Book book, Customer customer) {
        this.book = book;
        this.customer = customer;
        this.loanDate = new Date();
        this.isActive = true;
    }

    public UUID getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void returnBook() {
        this.returnDate = new Date();
        this.book.setAvailable(true);
        this.isActive = false;
    }
}

import java.util.Date;
import java.util.UUID;

public class Book {
    private final UUID id = UUID.randomUUID();
    private String title;
    private Author author;
    private boolean isAvailable;
    private final Date createdAt;
    private Date updatedAt;

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        this.touch();
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
        this.touch();
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
        this.touch();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    private void touch() {
        this.updatedAt = new Date();
    }
}

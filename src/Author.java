import java.util.Date;
import java.util.UUID;

public class Author {
    private final UUID id = UUID.randomUUID();
    private String name;
    private Date birthdate;

    public Author (String name, Date birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
}

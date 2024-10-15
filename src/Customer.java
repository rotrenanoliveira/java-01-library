import java.util.Date;
import java.util.UUID;

public class Customer {
    private final UUID id = UUID.randomUUID();
    private String name;
    private String email;
    private Date birthdate;

    public Customer(String name, String email, Date birthdate) {
        this.name = name;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
}
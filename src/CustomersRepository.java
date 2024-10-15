import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomersRepository {
    public List<Customer> customers = new ArrayList<Customer>();

    public Customer findById(String customerID) throws RuntimeException {
        return customers
            .stream()
            .filter(customer -> customer.getId().equals(UUID.fromString(customerID)))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Book not found."));
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void create(Customer customer) {
        customers.add(customer);
    }
}

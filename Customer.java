public class Customer {
    private String customerId;
    private String name;
    private String email;

    // Constructor
    public Customer(String customerId, String name, String email) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
    }

    // Getters
    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Convert customer object to string for saving in a file
    @Override
    public String toString() {
        return customerId + "," + name + "," + email;
    }

    // Create a customer object from a string (for reading from a file)
    public static Customer fromString(String line) {
        String[] parts = line.split(",");
        return new Customer(parts[0], parts[1], parts[2]);
    }
}


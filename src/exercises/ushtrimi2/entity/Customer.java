package exercises.ushtrimi2.entity;

public class Customer {

    private String customerId;
    private String name;

    public Customer(String id, String name) {
        this.customerId = id;
        this.name = name;
    }

    public String getId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("(Customer) %s : [%s]", name, customerId);
    }
}

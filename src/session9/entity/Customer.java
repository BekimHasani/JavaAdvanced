package session9.entity;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private long id;
    private Contact contact;
    private List<Contract> contracts;

    public Customer(long id) {
        this.id = id;
        this.contracts = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public Contact getContact() {
        return contact;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public void addContract(Contract contract) {
        contracts.add(contract);
    }

    @Override
    public String toString() {
        String toString = String.format("Customer id: %d, Contact: %s", id, contact);
        for (Contract contract : contracts) {
            toString += String.format("%n\t%s", contract);
        }
        return toString;
    }
}

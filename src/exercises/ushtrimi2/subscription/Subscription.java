package exercises.ushtrimi2.subscription;

import exercises.ushtrimi2.entity.Contact;
import exercises.ushtrimi2.services.Service;

import java.util.ArrayList;
import java.util.List;

public abstract class Subscription {

    private long id;
    private Contact contact;
    private List<Service> services;
    private long contractId;

    public Subscription(long id, long contractId) {
        this.id = id;
        this.services = new ArrayList<>();
        this.contractId = contractId;
    }

    public long getId() {
        return id;
    }

    public Contact getContact() {
        return contact;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public void addService(Service service) {
        services.add(service);
    }

    public long getContractId() {
        return contractId;
    }

    @Override
    public String toString() {
        String toString = String.format("Subscription (%s) id: %d, Contact: %s", getClass().getSimpleName(), id, contact);
        for (Service service : services) {
            toString += String.format("%n\t\t\t%s", service);
        }
        return toString;
    }
}

package session9.subscription;

import session9.entity.Contact;
import session9.services.Service;

import java.util.ArrayList;
import java.util.List;

public abstract class Subscription {

    private long id;
    private Contact contact;
    private List<Service> services;

    public Subscription(long id) {
        this.id = id;
        this.services = new ArrayList<>();
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

    @Override
    public String toString() {
        String toString = String.format("Subscription (%s) id: %d, Contact: %s", getClass().getSimpleName(), id, contact);
        for (Service service : services) {
            toString += String.format("%n\t\t\t%s", service);
        }
        return toString;
    }
}

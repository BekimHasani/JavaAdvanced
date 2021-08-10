package session9.entity;

import session9.subscription.Subscription;

import java.util.ArrayList;
import java.util.List;

public class Contract {

    private long id;
    private Contact contact;
    private List<Subscription> subscriptions;

    public Contract(long id) {
        this.id = id;
        this.subscriptions = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public Contact getContact() {
        return contact;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    @Override
    public String toString() {
        String toString = String.format("Contract id: %d, Contact: %s", id, contact);
        for (Subscription subscription : subscriptions) {
            toString += String.format("%n\t\t%s", subscription);
        }
        return toString;
    }

        public void setContact(Contact contact) {
        this.contact = contact;
    }

    public void add(Subscription subscription) {
        subscriptions.add(subscription);
    }
}

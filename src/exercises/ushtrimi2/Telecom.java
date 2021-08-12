package exercises.ushtrimi2;

import exercises.ushtrimi2.builders.DataIO;
import exercises.ushtrimi2.entity.Contact;
import exercises.ushtrimi2.entity.Contract;
import exercises.ushtrimi2.entity.Customer;
import exercises.ushtrimi2.services.Service;
import exercises.ushtrimi2.subscription.Subscription;

import java.util.List;

public class Telecom {


    public static void main(String[] args) {

        List<Subscription> subscriptions = DataIO.getSubscriptions();
        List<Customer> customers = DataIO.getCustomers();
        List<Service> services = DataIO.getServices();
        List<Contract> contract= DataIO.getContracts();
        List<Contact> contacts = DataIO.getContacts();
        System.out.println(subscriptions.size());
        System.out.println(customers.size());
        System.out.println(services.size());
        System.out.println(contacts.size());
        System.out.println(contract.size());
        subscriptions.forEach(System.out::println);

    }
}

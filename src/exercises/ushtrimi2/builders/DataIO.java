package exercises.ushtrimi2.builders;

import exercises.ushtrimi2.entity.Contact;
import exercises.ushtrimi2.entity.Contract;
import exercises.ushtrimi2.entity.Customer;
import exercises.ushtrimi2.services.Service;
import exercises.ushtrimi2.subscription.Subscription;

import java.util.List;

public final class DataIO {

    private static final String CONTACT_FILE = "C:\\Users\\BekimH\\Documents\\JavaAdvanced\\data\\contact.csv";
    private static final String CONTRACT_FILE = "C:\\Users\\BekimH\\Documents\\JavaAdvanced\\data\\contract.csv";
    private static final String CUSTOMER_FILE = "C:\\Users\\BekimH\\Documents\\JavaAdvanced\\data\\customer.csv";
    private static final String SERVICE_FILE = "C:\\Users\\BekimH\\Documents\\JavaAdvanced\\data\\service.csv";
    private static final String SUBSCRIPTION_FILE = "C:\\Users\\BekimH\\Documents\\JavaAdvanced\\data\\subscription.csv";

    protected static List<Contact> contacts;
    protected static List<Contract> contracts;
    protected static List<Customer> customers;
    protected static List<Subscription> subscriptions;
    protected static List<Service> services;


    static{
        services = BuilderFactory.createServices(SERVICE_FILE);
        contacts = BuilderFactory.createContacts(CONTACT_FILE);
        subscriptions = BuilderFactory.createSubscription(SUBSCRIPTION_FILE);
        contracts = BuilderFactory.createContract(CONTRACT_FILE);
        customers = BuilderFactory.createCustomers(CUSTOMER_FILE);
    }

    public static List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public static List<Contact> getContacts() {
        return contacts;
    }

    public static List<Contract> getContracts() {
        return contracts;
    }

    public static List<Customer> getCustomers() {
        return customers;
    }

    public static List<Service> getServices() {
        return services;
    }
}

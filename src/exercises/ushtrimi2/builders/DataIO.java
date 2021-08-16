package exercises.ushtrimi2.builders;

import exercises.ushtrimi2.entity.Contact;
import exercises.ushtrimi2.entity.Contract;
import exercises.ushtrimi2.entity.Customer;
import exercises.ushtrimi2.services.Service;
import exercises.ushtrimi2.subscription.Subscription;

import java.util.List;

public final class DataIO {

    private static final String CONTACT_FILE = "C:\\Users\\lenovo\\IdeaProjects\\JavaAdvanced\\data\\contact.csv";
    private static final String CONTRACT_FILE = "C:\\Users\\lenovo\\IdeaProjects\\JavaAdvanced\\data\\contract.csv";
    private static final String CUSTOMER_FILE = "C:\\Users\\lenovo\\IdeaProjects\\JavaAdvanced\\data\\customer.csv";
    private static final String SERVICE_FILE = "C:\\Users\\lenovo\\IdeaProjects\\JavaAdvanced\\data\\service.csv";
    private static final String SUBSCRIPTION_FILE = "C:\\Users\\lenovo\\IdeaProjects\\JavaAdvanced\\data\\subscription.csv";

    protected static List<Contact> contacts;
    protected static List<Contract> contracts;
    protected static List<Customer> customers;
    protected static List<Subscription> subscriptions;
    protected static List<Service> services;


    static{
        contacts = BuilderFactory.createContacts(CONTACT_FILE);
        services = BuilderFactory.createServices(SERVICE_FILE);
        subscriptions = BuilderFactory.createSubscription(SUBSCRIPTION_FILE);
        contracts = BuilderFactory.createContract(CONTRACT_FILE);
        customers = BuilderFactory.createCustomers(CUSTOMER_FILE);
    }

    public static List<Subscription> getSubscriptions() {
        return subscriptions;
    }

}

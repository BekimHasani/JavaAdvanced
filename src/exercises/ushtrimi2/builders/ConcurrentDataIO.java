package exercises.ushtrimi2.builders;

import exercises.ushtrimi2.entity.Contact;
import exercises.ushtrimi2.entity.Contract;
import exercises.ushtrimi2.entity.Customer;
import exercises.ushtrimi2.services.Service;
import exercises.ushtrimi2.subscription.Subscription;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public final class ConcurrentDataIO {

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

        ExecutorService executor = Executors.newFixedThreadPool(5);

        List<Callable<Object>> tasks = new ArrayList<>();
        tasks.add(() -> BuilderFactory.createContacts(CONTACT_FILE));
        tasks.add(() -> BuilderFactory.createServices(SERVICE_FILE));
        tasks.add(() -> BuilderFactory.createSubscription(SUBSCRIPTION_FILE));
        tasks.add(() -> BuilderFactory.createContract(CONTRACT_FILE));
        tasks.add(() -> BuilderFactory.createCustomers(CUSTOMER_FILE));

        System.out.println("out");
        try {
            System.out.println("start");
            executor.invokeAll(tasks);
            System.out.println("done");
            executor.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static List<Subscription> getSubscriptions() {
        return subscriptions;
    }

}

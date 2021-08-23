package exercises.ushtrimi3.concurrentTelecom.builders;


import exercises.ushtrimi3.concurrentTelecom.subscription.Subscription;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ConcurrentDataIO extends Data {

    private static List<String> contactData;
    private static List<String> contractData;
    private static List<String> customerData;
    private static List<String> subscriptionData;
    private static List<String> serviceData;


    public ConcurrentDataIO() {
        removeAll();
        init();
        contacts = BuilderFactory.createContacts(contactData);
        services = BuilderFactory.createServices(serviceData);
        subscriptions = BuilderFactory.createSubscription(subscriptionData);
        contracts = BuilderFactory.createContract(contractData);
        customers = BuilderFactory.createCustomers(customerData);
    }

    private static void init() {

        List<Callable<Void>> tasks = new ArrayList<>();

        tasks.add(() -> {
            contactData = readFile("\\contact.csv");
            return null;
        });

        tasks.add(() -> {
            contractData = readFile("\\contract.csv");
            return null;
        });

        tasks.add(() -> {
            customerData = readFile("\\customer.csv");
            return null;
        });
        tasks.add(() -> {
            subscriptionData = readFile("\\subscription.csv");
            return null;
        });
        tasks.add(() -> {
            serviceData = readFile("\\service.csv");
            return null;
        });

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        try {
            executorService.invokeAll(tasks);
            executorService.shutdown();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }
}

package exercises.ushtrimi3.concurrentTelecom.builders;

import exercises.ushtrimi3.concurrentTelecom.entity.Contact;
import exercises.ushtrimi3.concurrentTelecom.entity.Contract;
import exercises.ushtrimi3.concurrentTelecom.entity.Customer;
import exercises.ushtrimi3.concurrentTelecom.services.Service;
import exercises.ushtrimi3.concurrentTelecom.subscription.Subscription;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Data {

    private static final String ROOT = "C:\\Users\\BekimH\\Documents\\JavaAdvanced\\data";

    protected static List<Contact> contacts;
    protected static List<Contract> contracts;
    protected static List<Customer> customers;
    protected static List<Subscription> subscriptions;
    protected static List<Service> services;

    protected static List<String> readFile(String path) {
        try {
            Thread.sleep(3000);
            return Files.readAllLines(Path.of(ROOT + path))
                    .stream()
                    .skip(1)
                    .collect(Collectors.toList());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public abstract List<Subscription> getSubscriptions();


    protected void removeAll(){
        contacts = new ArrayList<>();
        contracts = new ArrayList<>();
        customers = new ArrayList<>();
        subscriptions = new ArrayList<>();
        services = new ArrayList<>();
    }

}

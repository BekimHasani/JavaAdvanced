package exercises.ushtrimi2.builders;


import exercises.ushtrimi2.entity.Contact;
import exercises.ushtrimi2.entity.Contract;
import exercises.ushtrimi2.entity.Customer;
import exercises.ushtrimi2.services.*;
import exercises.ushtrimi2.subscription.Fix;
import exercises.ushtrimi2.subscription.Mobile;
import exercises.ushtrimi2.subscription.Subscription;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BuilderFactory {

    public static List<Contact> createContacts(String path){
        List<Contact> contacts = new ArrayList<>();
        try (LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(path))) {
            List<String> rows = lineNumberReader.lines().collect(Collectors.toList());
            rows.remove(0);
            for (String row: rows) {
                String[] values = row.split(",");
                long contactId = Long.parseLong(values[0]);
                String name = values[1];
                String lastName = values[2];
                String phoneNumber = values[3];
                Contact contact = new Contact(contactId, name, lastName, phoneNumber);
                contacts.add(contact);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    public static List<Subscription> createSubscription(String path){
        List<Subscription> subscriptions = new ArrayList<>();
        try (LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(path))) {
            List<String> rows = lineNumberReader.lines().collect(Collectors.toList());
            rows.remove(0);
            for (String row: rows) {
                Subscription subscription = null;
                String[] values = row.split(",");
                long contractId = Long.parseLong(values[0]);
                long subscriptionId = Long.parseLong(values[1]);
                String type = values[2].toUpperCase();
                switch (type) {
                    case "MOBILE":{
                        subscription = new Mobile(contractId, subscriptionId);
                        break;
                    }
                    case "FIX" : {
                        subscription = new Fix(contractId, subscriptionId);
                        break;
                    }
                }
                for (Service service : DataIO.services){
                    if (service.getSubscriptionId() == subscriptionId){
                        subscription.addService(service);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return subscriptions;
    }

    public static List<Customer> createCustomers(String path){
        List<Customer> customers = new ArrayList<>();
        try (LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(path))) {
            List<String> rows = lineNumberReader.lines().collect(Collectors.toList());
            rows.remove(0);
            for (String row: rows) {
                String[] values = row.split(",");
                long customerId = Long.parseLong(values[0]);
                String name = values[1];
                Contact contact = getCustomerContact(customerId);
                customers.add(new Customer(customerId, contact, name));
            }
        } catch (IOException | NotFound e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Contract> createContract(String path){
        List<Contract> contracts = new ArrayList<>();
        try (LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(path))) {
            List<String> rows = lineNumberReader.lines().collect(Collectors.toList());
            rows.remove(0);
            for (String row: rows) {
                String[] values = row.split(",");
                long customerId = Long.parseLong(values[0]);
                long contractId = Long.parseLong(values[1]);
                String name = values[2];
                Contract contract = new Contract(contractId, name, customerId);
                for (Subscription subscription : DataIO.subscriptions){
                    if (subscription.getContractId()==contractId){
                        contract.add(subscription);
                    }
                }
                contracts.add(contract);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contracts;
    }

    public static List<Service> createServices(String path){
        List<Service> services = new ArrayList<>();
        try (LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(path))) {
            List<String> rows = lineNumberReader.lines().collect(Collectors.toList());
            rows.remove(0);
            for (String row: rows) {
                String[] values = row.split(",");
                long serviceId = Long.parseLong(values[0]);
                long subscriptionId = Long.parseLong(values[1]);
                String type = values[2].toUpperCase();
                switch (type){
                    case "VOICE":
                        services.add(new Voice(serviceId, subscriptionId));
                        break;
                    case "SMS" :
                        services.add(new SMS(serviceId, subscriptionId));
                        break;
                    case "CABLE" :
                        services.add(new Cable(serviceId, subscriptionId));
                        break;
                    case "INTERNET" :
                        services.add(new Internet(serviceId, subscriptionId));
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return services;
    }


    private static Contact getCustomerContact(long customerId) throws NotFound {
        List<Contract> contracts = DataIO.contracts;
        Optional<Contract> contract = contracts.stream().filter(c -> c.getCostumerId()==customerId).findAny();
        return contract.orElseThrow(NotFound::new).getContact();
    }
}

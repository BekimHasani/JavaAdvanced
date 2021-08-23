package exercises.ushtrimi2.builders;


import exercises.ushtrimi2.entity.Contact;
import exercises.ushtrimi2.entity.Contract;
import exercises.ushtrimi2.entity.Customer;
import exercises.ushtrimi2.services.*;
import exercises.ushtrimi2.subscription.Fix;
import exercises.ushtrimi2.subscription.Mobile;
import exercises.ushtrimi2.subscription.Subscription;

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
                long referenceId = Long.parseLong(values[0]);
                String name = values[1];
                String lastName = values[2];
                String phoneNumber = values[3];
                Contact contact = new Contact(referenceId, name, lastName, phoneNumber);
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
                        subscription = new Mobile(subscriptionId, contractId);
                        break;
                    }
                    case "FIX" : {
                        subscription = new Fix(subscriptionId, contractId);
                        break;
                    }
                }


                for (Service service : DataIO.services){
                    if (service.getSubscriptionId() == subscriptionId){
                        subscription.addService(service);
                    }
                }

                subscription.setContact(
                        DataIO.contacts.stream()
                                .filter(con -> con.getReferenceId() == subscriptionId)
                                .findAny()
                                .get());

                subscriptions.add(subscription);
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
                Customer customer = new Customer(customerId, contact, name);

                customer.addContract(
                        DataIO.contracts.stream().
                                filter( contract -> contract.getCostumerId() == customerId)
                                .findAny()
                                .get());
                customers.add(customer);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return customers;
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

                contract.add(
                        DataIO.subscriptions.stream().
                                filter(subscription -> subscription.getContractId() == contractId)
                                .findAny()
                                .get()
                );
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
                        services.add(new Voice(subscriptionId, serviceId));
                        break;
                    case "SMS" :
                        services.add(new SMS(subscriptionId, serviceId));
                        break;
                    case "CABLE" :
                        services.add(new Cable(subscriptionId, serviceId));
                        break;
                    case "INTERNET" :
                        services.add(new Internet(subscriptionId, serviceId));
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return services;
    }


    private static Contact getCustomerContact(long customerId) throws ClassNotFoundException {
        List<Contract> contracts = DataIO.contracts;
        Optional<Contract> contract = contracts.stream().filter(c -> c.getCostumerId()==customerId).findAny();
        return contract.orElseThrow(ClassNotFoundException::new).getContact();
    }
}

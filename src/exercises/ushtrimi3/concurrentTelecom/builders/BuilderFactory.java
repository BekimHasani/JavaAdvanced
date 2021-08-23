package exercises.ushtrimi3.concurrentTelecom.builders;


import exercises.ushtrimi3.concurrentTelecom.entity.Contact;
import exercises.ushtrimi3.concurrentTelecom.entity.Contract;
import exercises.ushtrimi3.concurrentTelecom.entity.Customer;
import exercises.ushtrimi3.concurrentTelecom.services.*;
import exercises.ushtrimi3.concurrentTelecom.subscription.Fix;
import exercises.ushtrimi3.concurrentTelecom.subscription.Mobile;
import exercises.ushtrimi3.concurrentTelecom.subscription.Subscription;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BuilderFactory {


    public static List<Contact> createContacts(List<String> data) {
        List<Contact> contacts = new ArrayList<>();
        data.forEach((row) -> {
            String[] values = row.split(",");
            long referenceId = Long.parseLong(values[0]);
            String name = values[1];
            String lastName = values[2];
            String phoneNumber = values[3];
            Contact contact = new Contact(referenceId, name, lastName, phoneNumber);
            contacts.add(contact);
        });
        return contacts;
    }

    public static List<Subscription> createSubscription(List<String> data) {
        List<Subscription> subscriptions = new ArrayList<>();
        data.forEach((row) -> {
            Subscription subscription = null;
            String[] values = row.split(",");
            long contractId = Long.parseLong(values[0]);
            long subscriptionId = Long.parseLong(values[1]);
            String type = values[2].toUpperCase();
            switch (type) {
                case "MOBILE": {
                    subscription = new Mobile(subscriptionId, contractId);
                    break;
                }
                case "FIX": {
                    subscription = new Fix(subscriptionId, contractId);
                    break;
                }
            }


            for (Service service : Data.services) {
                if (service.getSubscriptionId() == subscriptionId) {
                    subscription.addService(service);
                }
            }

            subscription.setContact(
                    Data.contacts.stream()
                            .filter(con -> con.getReferenceId() == subscriptionId)
                            .findAny()
                            .get());

            subscriptions.add(subscription);
        });
        return subscriptions;
    }

    public static List<Customer> createCustomers(List<String> data) {
        List<Customer> customers = new ArrayList<>();
        data.forEach((row) -> {
            String[] values = row.split(",");
            long customerId = Long.parseLong(values[0]);
            String name = values[1];
            Contact contact = null;
            try {
                contact = getCustomerContact(customerId);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Customer customer = new Customer(customerId, contact, name);

            customer.addContract(
                    Data.contracts.stream().
                            filter(contract -> contract.getCostumerId() == customerId)
                            .findAny()
                            .get());
            customers.add(customer);
        });
        return customers;
    }

    public static List<Contract> createContract(List<String> data) {
        List<Contract> contracts = new ArrayList<>();
        data.forEach((row) -> {
            String[] values = row.split(",");
            long customerId = Long.parseLong(values[0]);
            long contractId = Long.parseLong(values[1]);
            String name = values[2];
            Contract contract = new Contract(contractId, name, customerId);

            contract.add(
                    Data.subscriptions.stream().
                            filter(subscription -> subscription.getContractId() == contractId)
                            .findAny()
                            .get()
            );
            contracts.add(contract);
        });
        return contracts;
    }

    public static List<Service> createServices(List<String> data) {
        List<Service> services = new ArrayList<>();
        data.forEach((row) -> {
            String[] values = row.split(",");
            long serviceId = Long.parseLong(values[0]);
            long subscriptionId = Long.parseLong(values[1]);
            String type = values[2].toUpperCase();
            switch (type) {
                case "VOICE":
                    services.add(new Voice(subscriptionId, serviceId));
                    break;
                case "SMS":
                    services.add(new SMS(subscriptionId, serviceId));
                    break;
                case "CABLE":
                    services.add(new Cable(subscriptionId, serviceId));
                    break;
                case "INTERNET":
                    services.add(new Internet(subscriptionId, serviceId));
                    break;
            }
        });
        return services;
    }


    private static Contact getCustomerContact(long customerId) throws ClassNotFoundException {
        List<Contract> contracts = Data.contracts;
        Optional<Contract> contract = contracts.stream().filter(c -> c.getCostumerId() == customerId).findAny();
        return contract.orElseThrow(ClassNotFoundException::new).getContact();
    }
}

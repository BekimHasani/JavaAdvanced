package exercises.ushtrimi2;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import exercises.ushtrimi2.entity.Contact;
import exercises.ushtrimi2.entity.Contract;
import exercises.ushtrimi2.entity.Customer;
import exercises.ushtrimi2.services.Cable;
import exercises.ushtrimi2.services.SMS;
import exercises.ushtrimi2.services.Service;
import exercises.ushtrimi2.subscription.Fix;
import exercises.ushtrimi2.subscription.Mobile;
import exercises.ushtrimi2.subscription.Subscription;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static jdk.nashorn.internal.objects.NativeArray.forEach;

public class DataIO {

    private static List<Service> services = null;
    private static List<Customer> customers = null;
    private static List<Subscription> subscriptions = null;
    private static List<Contact> contacts = null;
    private static List<Contract> contracts = null;

    public static void main(String[] args) {
        File file = new File("C:\\Users\\BekimH\\Documents\\inputFiles");
        File[] files = file.listFiles();
        Map<String, List<String>> rows = new HashMap<>();
        try {
            for (File f : files) {
                rows.put(f.getName(), extracted(f));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Set<String> clases = rows.keySet();


        for (String clazz : clases) {
            if (clazz.equalsIgnoreCase("Contact.csv")) {
                contacts = createContactObj(rows.get(clazz));
            } else if (clazz.equalsIgnoreCase("Customer.csv")) {
                customers = createCustomerObj(rows.get(clazz));
            } else if (clazz.equalsIgnoreCase("Contract.csv")) {
                contracts = createContractObj(rows.get(clazz));
            } else if (clazz.equalsIgnoreCase("Subscription.csv")) {
                subscriptions = createSubscriptionObj(rows.get(clazz));
            } else if (clazz.equalsIgnoreCase("Service.csv")) {
                services = createServiceObj(rows.get(clazz));
            }
        }

        for (Customer cus : customers) {
            System.out.println(cus + "," + findContactById(cus.getId()));
        }

        for (Contract con : contracts) {
            System.out.println(con + "," + findContactById(con.getContractId()));
        }

        for (Subscription sub : subscriptions) {
            System.out.println(sub);
            List<Service> services = findServiceBySubscription(sub.getSubscriptionId());
            services.forEach(service -> {
                System.out.println(service);
            });
        }


    }

    private static Contact findContactById(String id) {
        for (Contact con : contacts)
            if (con.getId().equals(id))
                return con;
        return null;
    }

    private static List<Customer> createCustomerObj(List<String> strings) {
        String[] vars = null;
        List<Customer> customers = new ArrayList<>();
        for (String s : strings) {
            vars = s.split(",");
            customers.add(new Customer(vars[0], vars[1]));
        }
        return customers;
    }

    private static List<Contact> createContactObj(List<String> strings) {
        String[] vars = null;
        List<Contact> contacts = new ArrayList<>();
        for (String s : strings) {
            vars = s.split(",");
            contacts.add(new Contact(vars[0], vars[1], vars[2], vars[3]));
        }
        return contacts;
    }

    private static List<Contract> createContractObj(List<String> strings) {
        String[] vars = null;
        List<Contract> contracts = new ArrayList<>();
        for (String s : strings) {
            vars = s.split(",");
            contracts.add(new Contract(vars[0], vars[1], vars[2]));
        }
        return contracts;
    }

    private static List<Subscription> createSubscriptionObj(List<String> strings) {
        String[] vars = null;
        List<Subscription> subscriptions = new ArrayList<>();
        for (String s : strings) {
            vars = s.split(",");
            if (vars[2].equalsIgnoreCase("Mobile"))
                subscriptions.add(new Mobile(vars[0], vars[1]));
            else
                subscriptions.add(new Fix(vars[0], vars[1]));
        }
        return subscriptions;
    }

    private static List<Service> createServiceObj(List<String> strings) {
        String[] vars = null;
        List<Service> services = new ArrayList<>();
        for (String s : strings) {
            vars = s.split(",");
            if (vars[2].equalsIgnoreCase("Sms"))
                services.add(new SMS(vars[0], vars[2]));
            else
                services.add(new Cable(vars[0], vars[1]));
        }
        return services;
    }

    private static List<String> extracted(File file) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader(file));
        Stream<String> rows = bf.lines();
        List<String> list = rows.collect(Collectors.toList());
        list.remove(0);
        return list;
    }

    private static List<Service> findServiceBySubscription(String id) {
        List<Service> servs = new ArrayList<>();
        for (Service serv : services) {
            if (serv.getSubscriptionId().equals(id))
            servs.add(serv);
        }
        return servs;
    }
}
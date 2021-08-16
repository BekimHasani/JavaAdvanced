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
        subscriptions.forEach(System.out::println);

    }
}

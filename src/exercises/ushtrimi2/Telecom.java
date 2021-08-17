package exercises.ushtrimi2;

import exercises.ushtrimi2.builders.DataIO;
import exercises.ushtrimi2.subscription.Subscription;

import java.util.List;

public class Telecom {


    public static void main(String[] args) {

        List<Subscription> subscriptions = DataIO.getSubscriptions();
        subscriptions.forEach(System.out::println);

    }
}

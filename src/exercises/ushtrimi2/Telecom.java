package exercises.ushtrimi2;

import exercises.ushtrimi2.builders.DataIO;
import exercises.ushtrimi2.subscription.Subscription;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Telecom {


    public static void main(String[] args) {

        long start = System.nanoTime();
        List<Subscription> subscriptions = DataIO.getSubscriptions();
        long end = System.nanoTime();
        System.out.printf("Duration with sequent programing : %d sec %n", TimeUnit.NANOSECONDS.toSeconds(end-start));
        subscriptions.forEach(System.out::println);

    }
}

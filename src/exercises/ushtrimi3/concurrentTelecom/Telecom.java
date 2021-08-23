package exercises.ushtrimi3.concurrentTelecom;

import exercises.ushtrimi3.concurrentTelecom.builders.ConcurrentDataIO;
import exercises.ushtrimi3.concurrentTelecom.builders.Data;
import exercises.ushtrimi3.concurrentTelecom.builders.DataIO;
import exercises.ushtrimi3.concurrentTelecom.subscription.Subscription;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Telecom {


    public static void main(String[] args) {

        long start = System.nanoTime();
        Data data = new DataIO();
        System.out.println(start);
        List<Subscription> subscriptions = data.getSubscriptions();
        long end = System.nanoTime();
        System.out.println(end);
        subscriptions.forEach(System.out::println);
        System.out.printf("%nDuration with sequent programing : %d sec %n", TimeUnit.NANOSECONDS.toSeconds(end - start));

        System.out.println("-----------------------------------------------");

        start = System.nanoTime();
        data = new ConcurrentDataIO();
        List<Subscription> subscriptions1 = data.getSubscriptions();
        end = System.nanoTime();
        subscriptions1.forEach(System.out::println);
        System.out.printf("%nDuration with concurrent programing : %d sec %n", TimeUnit.NANOSECONDS.toSeconds(end-start));

    }
}

package session3.nested;

public class CounterTest {
    public static void main(String[] args) {
        Counter counter1 = Counter.getInstance();
        System.out.printf("counter1 = %d%n", counter1.getCount());
        System.out.printf("counter1 = %d%n", counter1.getCount());

        Counter counter2 = Counter.getInstance();
        System.out.printf("counter2 = %d%n", counter2.getCount());
        System.out.printf("counter2 = %d%n", counter2.getCount());
    }
}

package session16;

public class SimpleThreadTest {
    public static void main(String[] args) {
        Thread thread = new SimpleThread("Fatos");
        Thread thread2 = new SimpleThread("Fidan");
        Thread thread3 = new SimpleThread("Agron");
        thread.start();
        thread2.start();
        thread3.start();
    }
}

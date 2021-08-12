package session13;

public class RunnableTest {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("Thread priniting...."));
        thread.start();
        System.out.println("Main ENDED");
    }
}

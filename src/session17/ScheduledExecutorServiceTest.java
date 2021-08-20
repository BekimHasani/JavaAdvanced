package session17;

import java.util.concurrent.*;

public class ScheduledExecutorServiceTest {
    public static void main(String[] args) {
        final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
//        final ScheduledFuture<String> future = scheduledExecutorService.schedule(() -> "Hello from scheduled", 5, TimeUnit.SECONDS);
//        printFuture(future);
        scheduledExecutorService.scheduleAtFixedRate(()-> System.out.println("HELLO FROM BAFF: "), 2, 3, TimeUnit.SECONDS);
        System.out.println("END MAIN");
//        scheduledExecutorService.shutdown();
//        scheduledExecutorService.
    }

    private static void printFuture(ScheduledFuture<String> future){
        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

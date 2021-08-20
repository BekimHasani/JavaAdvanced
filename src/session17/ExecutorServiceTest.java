package session17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceTest {

    public static void main(String[] args) {
        final ExecutorService executor = Executors.newSingleThreadExecutor();
        final ExecutorService executorService = Executors.newFixedThreadPool(10);
        final ExecutorService cachedExecutorService = Executors.newCachedThreadPool();

//        executor.execute(()->System.out.println("Executing..."));
//        final Future<String> future1 = executor.submit(() -> System.out.println("Run submit"), "Hello from BAFF");
//        printFuture(future1);

//        final Future<String> future2 = executor.submit(() -> "Tung nga BAFF");
//        printFuture(future2);
//
        final List<Callable<String>> list = Arrays.asList(
                (Callable<String>) () -> "Hello from BAFF 1",
                (Callable<String>) () -> "Hello from BAFF 2",
                (Callable<String>) () -> "Hello from BAFF 3"
        );

//        try {
//            final String result = executorService.invokeAny(list);
//            System.out.println(result);
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }

        try {
            final List<Future<String>> futures = cachedExecutorService.invokeAll(list);
            futures.forEach(ExecutorServiceTest::printFuture);
        }  catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("END MAIN");
        executor.shutdown();
        executorService.shutdown();
        cachedExecutorService.shutdown();
    }

    private static void printFuture(Future<String> future) {
        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
package exercises.ushtrimi3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ConcurrentApplication {


    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        long startTime = System.nanoTime();
        System.out.println("Sum : " + sequentialGetPrice(ints));
        long endTime = System.nanoTime();
        System.out.printf("Duration with sequential programing: %d sec%n", TimeUnit.NANOSECONDS.toSeconds(endTime - startTime));

        System.out.println("-----------------------------------------------------");

        startTime = System.nanoTime();
        System.out.println("Sum :" + concurrentGetPrice(ints));
        endTime = System.nanoTime();
        System.out.printf("Duration with concurrent programing: %d sec", TimeUnit.NANOSECONDS.toSeconds(endTime - startTime));
    }


    private static int sequentialGetPrice(List<Integer> ints) {
        int sum = 0;
        for (Integer i : ints) {
            sum += DummyService.getNum();
        }
        return sum;
    }

    private static int concurrentGetPrice(List<Integer> ints) {
        List<Callable<Integer>> tasks = new ArrayList<>();
        final ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i : ints) {
            tasks.add(() -> DummyService.getNum());
        }
        try {
            List<Future<Integer>> futures = executorService.invokeAll(tasks);
            int sum = 0;
            for (Future<Integer> future : futures) {
                sum += future.get();
            }
            executorService.shutdown();
            return sum;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        return -1;
    }
}



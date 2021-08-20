package session17.producerconsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerExecutorTest {
    public static void main(String[] args) {
//        Box box = new SynchronizeBox();
        final Box box = new LockBox();
        final ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(()->{
            for (int i = 1; i <= box.MAX; i++) {
                box.write(i);
            }
        });
        executorService.submit(()->{
            int value ;
            while((value = box.read()) <= box.MAX){
                System.out.println(value);
            }
        });
        executorService.shutdownNow();
//        Thread producer = new ProducerThread(box);
//        Thread consumer = new ConsumerThread(box);
//        consumer.start();
//        producer.start();
    }
}

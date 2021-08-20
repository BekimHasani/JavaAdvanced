package session17.producerconsumer;

public class ProducerConsumerTest {
    public static void main(String[] args) {
//        Box box = new SynchronizeBox();
        Box box = new LockBox();
        Thread producer = new ProducerThread(box);
        Thread consumer = new ConsumerThread(box);
        consumer.start();
        producer.start();
    }
}

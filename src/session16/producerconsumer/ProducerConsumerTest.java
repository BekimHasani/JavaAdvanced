package session16.producerconsumer;

public class ProducerConsumerTest {
    public static void main(String[] args) {
        Box box = new SynchronizeBox();
        Thread producer = new ProducerThread(box);
        Thread consumer = new ConsumerThread(box);
        consumer.start();
        producer.start();
    }
}

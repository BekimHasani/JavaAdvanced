package session17.producerconsumer;

public class MultiProducersConsumer {
    private static final Box box = new LockBox();

    public static void main(String[] args) {

        Thread producerStart = new ProducerStart();
        Thread consumer = new MultiConsumerThread(box);
        consumer.start();
        producerStart.start();
    }

    static class ProducerStart extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread thread = new MultiProducerThread(box, i * box.MAX);
                    thread.start();
                    thread.join();//Stop ProducerStart thread execution until MultiProducerThread has finished
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

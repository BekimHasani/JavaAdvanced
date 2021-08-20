package session17.producerconsumer;

public class MultiConsumerThread extends Thread {
    private Box box;

    public MultiConsumerThread(Box box) {
        this.box = box;
    }

    public void run(){
        while(true){
            System.out.println(box.read());
        }
    }
}

package session17.producerconsumer;

public class ConsumerThread extends Thread {
    private Box box;

    public ConsumerThread(Box box) {
        this.box = box;
    }

    public void run(){
        int val;
        while((val = box.read()) <= Box.MAX){
            System.out.println(val);
        }
    }
}

package session17.producerconsumer;

public class MultiProducerThread extends Thread{
    private Box box;
    private int start;
    public MultiProducerThread(Box box, int start){
        this.box = box;
        this.start = start;
    }

    @Override
    public void run(){
        for (int i=1; i<=box.MAX; i++){
            box.write(i+start);
        }
    }
}

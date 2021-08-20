package session17.producerconsumer;

public class ProducerThread extends Thread{
    private Box box;

    public ProducerThread(Box box){
        this.box = box;
    }

    @Override
    public void run(){
        for (int i=1; i<=box.MAX; i++){
            box.write(i);
        }
    }
}

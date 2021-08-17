package session16;

public class SimpleThread extends Thread{
    public SimpleThread(String name){
        super(name);
    }

    @Override
    public void run(){
        for (int i=0; i<100; i++){
            System.out.printf("[%s] %d%n",getName(), i);
            try {
                Thread.sleep((int)(Math.random() * 350));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("%s FINISHED....%n", getName());
    }
}

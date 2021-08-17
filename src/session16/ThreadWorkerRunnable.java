package session16;

public class ThreadWorkerRunnable extends Thread{

    public ThreadWorkerRunnable(Runnable run){
        super(run);
    }

    @Override
    public void run(){
        System.out.println("ThreadWorkerRunnable is running....");
    }
}

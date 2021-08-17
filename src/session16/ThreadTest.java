package session16;

public class ThreadTest {
    public static void main(String[] args) {
        Thread th = new ThreadWorker();
        th.start();
        System.out.println("Continue with main....");

        Thread th1 = new Thread(new RunnableWorker());
        th1.start();

        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous is running!");
            }
        });
        th2.start();

        Thread th3 = new Thread(()->System.out.println("Functional interface is running"));
        th3.start();

        Thread th4 = new ThreadWorkerRunnable(()-> System.out.println("Runnable of ThreadWorkerRunnable is running..."));
        th4.start();
    }
}

package session16;

public class SystemThreads {
    public static void main(String[] args) {
        ThreadGroup top = Thread.currentThread().getThreadGroup();
        ThreadGroup parent;
        while((parent = top.getParent()) != null){
            System.out.printf("Top: %s, parent: %s%n", top.getName(), parent.getName());
            top = parent;
        }

        Thread [] activeThreads = new Thread[top.activeCount()];
        top.enumerate(activeThreads);

        for (Thread thread : activeThreads) {
            System.out.println(thread);
        }
    }
}

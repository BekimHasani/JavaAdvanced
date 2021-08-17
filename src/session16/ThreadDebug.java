package session16;

public class ThreadDebug {

    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();
        System.out.printf("CPU: %d, Total memory %d, Free memory %d", rt.availableProcessors() , rt.totalMemory(), rt.freeMemory());
    }
}

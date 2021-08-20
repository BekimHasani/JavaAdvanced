package session17.producerconsumer;

public class SynchronizeBox implements Box {
    private int value;
    private boolean hasValue;

    @Override
    public synchronized void write(int value) {
        while (hasValue) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.value = value;
        hasValue = true;
        notify();
    }

    @Override
    public synchronized int read() {
        while (!hasValue) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hasValue = false;
        notify();
        return value;
    }
}

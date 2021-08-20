package session17.producerconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockBox implements Box {

    private Lock lock;
    private Condition writeCondition;
    private Condition readCondition;
    private int value;
    private boolean hasValue;

    public LockBox() {
        lock = new ReentrantLock();
        writeCondition = lock.newCondition();
        readCondition = lock.newCondition();
    }

    @Override
    public void write(int value) {
        try {
            lock.lock();
            while(hasValue){
                try {
                    writeCondition.await();
                } catch(InterruptedException ie){}
            }
            this.value = value;
            hasValue = true;
            readCondition.signal();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int read() {
        try {
            lock.lock();
            while(!hasValue){
                try {
                    readCondition.await();
                } catch(InterruptedException ie){}
            }
            hasValue = false;
            writeCondition.signal();
            return value;
        } finally {
            lock.unlock();
        }
    }
}

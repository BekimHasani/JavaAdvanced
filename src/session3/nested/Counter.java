package session3.nested;

import java.util.Objects;

public class Counter {
    private int count;
    private static Counter counter;

    private Counter(){
        super();
    }

    public int getCount(){
        return ++count;
    }

    private static class CounterInner {
        static {
            counter = new Counter();
        }

        public static Counter getCounter(){
            return counter;
        }
    }

    public static Counter getInstance(){
        return CounterInner.getCounter();
    }

}

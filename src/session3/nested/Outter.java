package session3.nested;

public class Outter {
    int value = 10;

    abstract class Inner {
        public abstract int getValue();

        public void print(){
            System.out.printf("Value = %d%n", getValue());
        }
    }
}

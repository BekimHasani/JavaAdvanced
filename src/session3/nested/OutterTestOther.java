package session3.nested;

public class OutterTestOther extends Outter{
    class InnerTestOther extends Inner{
        @Override
        public int getValue() {
            return value;
        }
    }
    public static void main(String[] args) {
        Outter.Inner inner = new OutterTestOther().new InnerTestOther();
        inner.print();
    }
}

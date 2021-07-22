package session3.nested;

public class OutterTest {
    public static void main(String[] args) {
        Outter outter = new Outter();
        Outter.Inner inner = outter.new Inner() {
            @Override
            public int getValue() {
                return outter.value;
            }
        };

        inner.print();
    }
}

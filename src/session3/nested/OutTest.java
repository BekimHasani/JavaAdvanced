package session3.nested;

public class OutTest {
    public static void main(String[] args) {
        Out out = new Out();
        Out.In in1 = out.new In();
        Out.In in2 = out.new In();
        in1.print();
        in2.print();
    }
}

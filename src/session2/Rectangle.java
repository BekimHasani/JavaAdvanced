package session2;

public class Rectangle extends Quadliteral{

    public Rectangle(int x, int y, int a, int b) {
        super(x, y, a, b, a, b);
    }

    public Rectangle(int x, int y, String colour, int a, int b) {
        super(x, y, colour, a, b, a, b);
    }

    @Override
    public double getArea() {
        return getA() * getB();
    }
}

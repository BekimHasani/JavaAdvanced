package session2;

public class Square extends Rectangle{
    public Square(int x, int y, int a) {
        super(x, y, a, a);
    }

    public Square(int x, int y, String colour, int a) {
        super(x, y, colour, a, a);
    }
}

package session2;

public abstract class Quadliteral extends Shape {
    private int a;
    private int b;
    private int c;
    private int d;

    public Quadliteral(int x, int y, int a, int b, int c, int d) {
        super(x, y);
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public Quadliteral(int x, int y, String colour, int a, int b, int c, int d) {
        super(x, y, colour);
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public int getD() {
        return d;
    }

    @Override
    public double getCircumference(){
        return a+b+c+d;
    }
}

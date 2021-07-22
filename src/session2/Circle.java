package session2;

public class Circle extends Shape {
    private double radius;

    public Circle(int x, int y, double radius) {
        super(x, y);
        this.radius = radius;
    }

    public Circle(int x, int y, String colour, double radius) {
        super(x, y, colour);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius,2);
    }

    @Override
    public double getCircumference() {
        return Math.PI * 2 * radius;
    }
}

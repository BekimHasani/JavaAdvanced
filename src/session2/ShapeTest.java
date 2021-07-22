package session2;

public class ShapeTest {
    public static void main(String[] args) {
        Shape [] shapes = new Shape[3];
        shapes[0] = new Circle(10, 10, "Blue", 15.5);
        shapes[1] = new Rectangle(20, 12, "Red", 10, 20);
        shapes[2] = new Square(15, 15, "Green", 15);

        for (Shape shape:shapes) {
            System.out.println(shape);
        }
    }
}

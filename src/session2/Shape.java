package session2;

public abstract class Shape {
    private int x;
    private int y;
    private String colour;

    public Shape(int x, int y) {
        this(x, y, "Black");
    }

    public Shape(int x, int y, String colour) {
        this.x = x;
        this.y = y;
        this.colour = colour;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getColour() {
        return colour;
    }

    public void move(int xDiff, int yDiff){

    }

    public abstract double getArea();

    public abstract double getCircumference();

    @Override
    public String toString() {
        return String.format("%s [%d,%d] %s: A:%.2f, C:%.2f",
                getClass().getSimpleName(), x,y, colour, getArea(), getCircumference());
    }
}

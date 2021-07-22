package session4;

public class PrintTest {
    public static void main(String[] args) {
        Printable printable = new Printer("HP Laser");
        printable.print();
        printable.print3D(100);
    }
}

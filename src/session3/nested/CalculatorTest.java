package session3.nested;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.printf("ADD = %d%n", calculator.add(10,20));
        System.out.printf("TEST ADDITION = %d%n", calculator.testAddition());
    }
}

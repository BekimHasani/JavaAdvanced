package session13;

public class Closure {
    public static void main(String[] args) {
        int x = 10;
        int y = 100;
        calculate(x, i -> System.out.printf("%d + %d = %d%n", i, y, (i+ y)));
    }

    private static void calculate(int x, Calculate calculate){
        calculate.doCalculate(x);
    }
}

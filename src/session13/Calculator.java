package session13;

import java.util.function.IntBinaryOperator;

public class Calculator {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int x = 40;
        int y = 0;
        IntBinaryOperator mutiply = ( a,  b) -> a * b;
        System.out.println(mutiply.applyAsInt(x, y));

        IntBinaryOperator division = ( a,  b) -> {
            if(b == 0){
                return 0;
            }
            return a / b;
        };
        System.out.println(division.applyAsInt(x, y));

        IntBinaryOperator addition = ( a,  b) -> a + b;
        System.out.println(addition.applyAsInt(x, y));

    }
}


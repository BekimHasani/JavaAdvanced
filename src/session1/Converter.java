package session1;

public class Converter {
    private static double dollarToEuroRate = 0.8568;

    public static double toDollar(double amount){
        return amount / dollarToEuroRate;
    }
}

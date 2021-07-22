package session1;

public enum Currency {
    EURO ("€", "Euro"),
    DOLLAR ("$", "Dollar"),
    LEK ("L", "Lek");

    private String symbol;
    private String name;

    Currency(String symbol, String name){
        this.symbol = symbol;
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }
}

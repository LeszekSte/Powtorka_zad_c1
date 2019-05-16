package zad_1;

public enum Operation {
    ADD("DODAWANIE","+"),
    MINUS("ODEJMOWANIE","-"),
    MULTIPLICATION("MNOŻENIE", "*" ),
    DIVISION("DZIELENIE","/");

    private final String description;
    private final String symbol;

    Operation(String description, String symbol) {
        this.description = description;
        this.symbol = symbol;
    }

    public String getDescription() {
        return description;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "description='" + description + '\'' +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}

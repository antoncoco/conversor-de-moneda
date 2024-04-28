package enums;

public enum Coin {
    USD("Dólar"),
    BRL("Real Brasileño"),
    COP("Peso colombiano"),
    ARS("Peso argentino");

    private final String coinName;

    Coin(String coinName) {
        this.coinName = coinName;
    }

    public String getCoinName() {
        return coinName;
    }
}

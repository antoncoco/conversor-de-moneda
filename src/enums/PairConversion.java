package enums;

public enum PairConversion {
    USD_TO_BRL(Coin.USD, Coin.BRL),
    BRL_TO_USD(Coin.BRL, Coin.USD),
    USD_TO_COP(Coin.USD, Coin.COP),
    COP_TO_USD(Coin.COP, Coin.USD),
    USD_TO_ARS(Coin.USD, Coin.ARS),
    ARS_TO_USD(Coin.ARS, Coin.USD);

    private final Coin coinBase;
    private final Coin coinTarget;

    PairConversion(Coin coinBase, Coin coinTarget) {
        this.coinBase = coinBase;
        this.coinTarget = coinTarget;
    }

    public Coin getCoinBase() {
        return this.coinBase;
    }

    public Coin getCoinTarget() {
        return this.coinTarget;
    }
}

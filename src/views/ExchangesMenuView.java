package views;

import enums.Coin;
import enums.PairConversion;

public class ExchangesMenuView {
    public static void showMenu() {
        System.out.println("*****************************");
        System.out.println("Bienvenido(a) al conversor de monedas de antoncocox");
        for (PairConversion pairConversionOption : PairConversion.values()) {
            int numberOfPairConversion = pairConversionOption.ordinal();
            System.out.println(
                    (++numberOfPairConversion)
                             + ") "
                             + pairConversionOption.getCoinBase().getCoinName()
                             + " => "
                             + pairConversionOption.getCoinTarget().getCoinName()
            );
        }
        System.out.println("Escoge la conversión que desees realizar:");
        System.out.println("*****************************");
    }
}

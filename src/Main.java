import com.google.gson.Gson;
import controllers.ExchangeRateController;
import dto.ExchangeRateDTO;
import enums.Coin;
import exceptions.HttpRequestFailedException;
import services.ExchangeRateConversionService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ExchangeRateController controller = new ExchangeRateController();
        try {
            ExchangeRateDTO coinInfo = controller.getExchangeInfoFromCoins(Coin.USD, Coin.BRL);
            Gson gson = new Gson();
            System.out.println(gson.toJson(coinInfo));
            System.out.println("500 usd a brl = " + ExchangeRateConversionService.convert(500, coinInfo));
        } catch (IOException | InterruptedException | HttpRequestFailedException e) {
            System.out.println(e.getMessage());
        }
    }
}
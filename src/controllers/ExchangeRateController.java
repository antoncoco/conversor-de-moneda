package controllers;

import clients.ExchangeRateClient;
import dto.ExchangeRateDTO;
import enums.Coin;
import enums.PairConversion;
import exceptions.HttpRequestFailedException;
import services.ExchangeRateConversionService;

import java.io.IOException;

public class ExchangeRateController {
    private final ExchangeRateClient exchangeRateClient;
    private final ExchangeRateConversionService exchangeRateConversionService;
    public ExchangeRateController(
            ExchangeRateClient exchangeRateClient,
            ExchangeRateConversionService exchangeRateConversionService
    ) {
        this.exchangeRateClient = exchangeRateClient;
        this.exchangeRateConversionService = exchangeRateConversionService;
    }

    public double getExchangeResultWithPairConversion(int initialValue, PairConversion pairConversion)
            throws HttpRequestFailedException, IOException, InterruptedException {
        ExchangeRateDTO exchangeInfoFromCoins = exchangeRateClient
                .getExchangeInfoFromCoins(pairConversion.getCoinBase(), pairConversion.getCoinTarget());
        return exchangeRateConversionService
                .convertAccordingToExchangeRate(initialValue, exchangeInfoFromCoins);
    }
}

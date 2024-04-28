package services;

import dto.ExchangeRateDTO;

public class ExchangeRateConversionService {
    public double convertAccordingToExchangeRate(int baseQuantity, ExchangeRateDTO exchangeRateDTO) {
        return baseQuantity * exchangeRateDTO.conversionRate();
    }
}

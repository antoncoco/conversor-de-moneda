package services;

import dto.ExchangeRateDTO;

public class ExchangeRateConversionService {
    public double convertAccordingToExchangeRate(double baseQuantity, ExchangeRateDTO exchangeRateDTO) {
        return baseQuantity * exchangeRateDTO.conversionRate();
    }
}

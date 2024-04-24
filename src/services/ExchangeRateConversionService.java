package services;

import dto.ExchangeRateDTO;

public class ExchangeRateConversionService {
    public static double convert(int baseQuantity, ExchangeRateDTO exchangeRateDTO) {
        return baseQuantity * exchangeRateDTO.conversionRate();
    }
}

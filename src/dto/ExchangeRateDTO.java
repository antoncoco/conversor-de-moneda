package dto;

public record ExchangeRateDTO(
        String result,
        String documentation,
        String termsOfUse,
        String baseCode,
        String targetCode,
        double conversionRate
) {
}

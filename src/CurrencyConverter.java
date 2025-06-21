public class CurrencyConverter {
    public static double convert(double amount, String fromCurrency, String toCurrency, ExchangeRateResponse rates) {
        Double rateFrom = rates.getConversionRates().get(fromCurrency);
        Double rateTo = rates.getConversionRates().get(toCurrency);

        if (rateFrom == null) {
            System.out.println("La moneda de origen '" + fromCurrency + "' no está disponible.");
            return 0;
        }
        if (rateTo == null) {
            System.out.println("La moneda de destino '" + toCurrency + "' no está disponible.");
            return 0;
        }

        double amountInUSD = amount / rateFrom;
        return amountInUSD * rateTo;
    }
}
import com.google.gson.Gson;
import java.util.Map;

public class ExchangeRateResponse {
    private String result;
    private String base_code;
    private Map<String, Double> conversion_rates;

    public String getResult() {
        return result;
    }

    public String getBaseCode() {
        return base_code;
    }

    public Map<String, Double> getConversionRates() {
        return conversion_rates;
    }

    public static ExchangeRateResponse fromJson(String json) {
        try {
            Gson gson = new Gson();
            return gson.fromJson(json, ExchangeRateResponse.class);
        } catch (Exception e) {
            System.out.println("Error al parsear JSON: " + e.getMessage());
            return null;
        }
    }
}
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateClient {
    private final HttpClient client = HttpClient.newHttpClient();

    public String getExchangeRates() {
        // URL de la API (puedes cambiar la base si usas otra moneda)
        String apiUrl = "https://v6.exchangerate-api.com/v6/3fdf0c4f554081d5ef5d9426/latest/USD";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body(); // Esto devuelve el JSON con todas las tasas
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al obtener las tasas de cambio: " + e.getMessage());
            return null;
        }
    }
}
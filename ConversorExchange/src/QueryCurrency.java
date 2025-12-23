import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

public class QueryCurrency {

    private static final String BASE_URL =
            "https://v6.exchangerate-api.com/v6/548601db710319ec477d18cb/pair/";

    private final HttpClient client = HttpClient.newHttpClient();
    private final Gson gson = new Gson();

    public CurrencyTarget query(String baseCode, String targetCode, double amount) {

        URI uri = URI.create(
                BASE_URL + baseCode + "/" + targetCode + "/" + amount
        );

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();

        try {
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            return gson.fromJson(response.body(), CurrencyTarget.class);

        } catch (Exception e) {
            throw new RuntimeException("RuntimeError", e);
        }
    }
}

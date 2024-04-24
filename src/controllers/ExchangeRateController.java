package controllers;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.ExchangeRateDTO;
import enums.Coin;
import exceptions.HttpRequestFailedException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.http.HttpResponse.BodyHandlers;

public class ExchangeRateController {
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final String API_URL = System.getenv("URL_EXCHANGE_RATE")
            + System.getenv("API_KEY") + "/pair/";

    public ExchangeRateController() {}

    public ExchangeRateDTO getExchangeInfoFromCoins(Coin base, Coin target) throws IOException, InterruptedException, HttpRequestFailedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + base.name() + "/" + target.name()))
                .header("Accept", "application/json")
                .GET()
                .build();
        HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            Gson gson = new GsonBuilder()
                    .setFieldNamingStrategy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();
            return gson.fromJson(response.body(), ExchangeRateDTO.class);
        }
        throw new HttpRequestFailedException(response.statusCode() + " " + response.body());
    }


}

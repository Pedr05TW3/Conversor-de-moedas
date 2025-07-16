package ConversorDeMoedas.Modelos;
import ConversorDeMoedas.Calculadora.ExchangeRateApi;
import ConversorDeMoedas.Principal.Principal;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor extends Principal {



    public ExchangeRateApi busca(String url, String moeda2){
        URI conversor = URI.create(url + moeda2);
        HttpRequest request = HttpRequest.newBuilder().uri(conversor).build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ExchangeRateApi.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Opção Inválida! Digite uma das opções existentes!");
        }

    }
}


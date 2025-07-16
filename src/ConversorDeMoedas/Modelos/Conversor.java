package ConversorDeMoedas.Modelos;
import ConversorDeMoedas.Calculadora.ExchangeRateApi;
import ConversorDeMoedas.Principal.Principal;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor extends Principal {
    String moeda1 = "";
    String moeda2 = "";
    String atualizacao = "";

    public String getMoeda1() {
        return moeda1;
    }

    public void setMoeda1(String moeda1) {
        this.moeda1 = moeda1;
    }

    public String getMoeda2() {
        return moeda2;
    }

    public void setMoeda2(String moeda2) {
        this.moeda2 = moeda2;
    }

    public String getAtualizacao() {
        return atualizacao;
    }

    public void setAtualizacao(String atualizacao) {
        this.atualizacao = atualizacao;
    }


    public ExchangeRateApi busca(String url, String moeda2){
        URI conversor = URI.create(url + moeda2);
        HttpRequest request = HttpRequest.newBuilder().uri(conversor).build();
    try {
        HttpResponse<String> response = HttpClient
                .newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return new Gson().fromJson(response.body(), ExchangeRateApi.class);
    } catch (Exception e) {

        throw new RuntimeException("Opção Inválida! Digite uma das opções existentes!");
    }

    }
}

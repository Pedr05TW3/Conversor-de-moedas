package ConversorDeMoedas.Principal;

import ConversorDeMoedas.Calculadora.ExchangeRateApi;
import ConversorDeMoedas.Modelos.Conversor;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String busca = "";
        String url = "";
        String moeda2 = "";

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (!busca.equalsIgnoreCase("fechar")){
            System.out.format("\nConversor de moedas - Escolha uma das opções:" +
                    "\nUSD $:  Dólar Americano" +
                    "\nBRL R$: Real Brasileiro" +
                    "\nEUR €:  Euro" +
                    "\nGBP £:  Libra Esterlina" +
                    "\nDigite 'fechar' para encerrar");
            busca = scanner.nextLine();
            if (busca.equalsIgnoreCase("fechar")) {
                break;
            }
            if (busca.equalsIgnoreCase("usd")){
                url = "https://v6.exchangerate-api.com/v6/c93a8a062ac04ee17122dd42/pair/usd/";
            } else if (busca.equalsIgnoreCase("brl")) {
                url = "https://v6.exchangerate-api.com/v6/c93a8a062ac04ee17122dd42/pair/brl/";
            }else if(busca.equalsIgnoreCase("eur")){
                url = "https://v6.exchangerate-api.com/v6/c93a8a062ac04ee17122dd42/pair/eur/";
            } else if (busca.equalsIgnoreCase("gbp")) {
                url = "https://v6.exchangerate-api.com/v6/c93a8a062ac04ee17122dd42/pair/gbp/";
            }

            System.out.println("\nVocê escolheu: " + busca.toUpperCase());
            System.out.format("\nConverter " + busca.toUpperCase() + " para:" +
                    "\nUSD $:  Dólar Americano" +
                    "\nBRL R$: Real Brasileiro" +
                    "\nEUR €:  Euro" +
                    "\nGBP £:  Libra Esterlina" +
                    "\nDigite 'fechar' para encerrar\n");
            busca = scanner.nextLine();
            if (busca.equalsIgnoreCase("usd")){
                moeda2 = "USD";
            } else if (busca.equalsIgnoreCase("brl")) {
                moeda2 = "BRL";
            }else if(busca.equalsIgnoreCase("eur")){
                moeda2 = "EUR";
            } else if (busca.equalsIgnoreCase("gbp")) {
                moeda2 = "GBP";
            }


        try {
            Conversor consulta = new Conversor();
            ExchangeRateApi consultarMoedas = consulta.busca(url, moeda2);
            System.out.println(consultarMoedas);

        } catch (JsonSyntaxException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }




        }
        System.out.println("O programa foi finalizado!");
    }
}

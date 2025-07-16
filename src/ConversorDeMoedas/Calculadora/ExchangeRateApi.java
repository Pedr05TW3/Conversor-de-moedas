package ConversorDeMoedas.Calculadora;

import java.util.Date;

public record ExchangeRateApi(String base_code, String target_code, String time_last_update_utc, String conversion_rate){
    @Override
    public String toString() {
        return "\nConversão: " +
                "\nMoeda a ser convertida: " + base_code +
                "\nConverter para: " + target_code +
                "\nÚltima atualização: " + time_last_update_utc +
                "\nResultado: " + conversion_rate;
    }
}

package br.com.ewerton.padraocamadas.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CnpjValidador {

    // Método para verificar se o CNPJ é válido
    public static boolean isValid(String cnpj) {
        // Verifica se o CNPJ é nulo ou tem um tamanho diferente de 14
        if (cnpj == null || cnpj.length() != 14) {
            return false;
        }

        // Verifica se o CNPJ tem apenas números
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(cnpj);
        if (!matcher.matches()) {
            return false;
        }

        // Valida os dois dígitos verificadores
        int sum = 0;
        int[] firstWeight = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        for (int i = 0; i < 12; i++) {
            sum += Integer.parseInt(String.valueOf(cnpj.charAt(i))) * firstWeight[i];
        }

        int firstDigit = sum % 11 < 2 ? 0 : 11 - sum % 11;
        if (firstDigit != Integer.parseInt(String.valueOf(cnpj.charAt(12)))) {
            return false;
        }

        sum = 0;
        int[] secondWeight = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        for (int i = 0; i < 13; i++) {
            sum += Integer.parseInt(String.valueOf(cnpj.charAt(i))) * secondWeight[i];
        }

        int secondDigit = sum % 11 < 2 ? 0 : 11 - sum % 11;
        return secondDigit == Integer.parseInt(String.valueOf(cnpj.charAt(13)));
    }

//    Para user o metodo: boolean isValid = CnpjValidator.isValid(cnpj);
}
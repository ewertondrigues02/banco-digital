package br.com.ewerton.padraocamadas.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CpfValidador {

    // Método para verificar se o CPF é válido
    public static boolean isValid(String cpf) {
        // Verifica se o CPF é nulo ou tem um tamanho diferente de 11
        if (cpf == null || cpf.length() != 11) {
            return false;
        }

        // Verifica se o CPF tem apenas números
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(cpf);
        if (!matcher.matches()) {
            return false;
        }

        // Valida os dois dígitos verificadores
        int sum = 0;
        int weight = 10;
        for (int i = 0; i < 9; i++) {
            sum += Integer.parseInt(String.valueOf(cpf.charAt(i))) * weight--;
        }

        int firstDigit = sum % 11 < 2 ? 0 : 11 - sum % 11;
        if (firstDigit != Integer.parseInt(String.valueOf(cpf.charAt(9)))) {
            return false;
        }

        sum = 0;
        weight = 11;
        for (int i = 0; i < 10; i++) {
            sum += Integer.parseInt(String.valueOf(cpf.charAt(i))) * weight--;
        }

        int secondDigit = sum % 11 < 2 ? 0 : 11 - sum % 11;
        return secondDigit == Integer.parseInt(String.valueOf(cpf.charAt(10)));
    }

//    Para verificar o cpf usar o metodo abaixo
//    boolean isValid = CpfValidator.isValid("12345678909");

}

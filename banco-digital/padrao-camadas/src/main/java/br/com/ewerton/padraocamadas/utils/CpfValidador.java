package br.com.ewerton.padraocamadas.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CpfValidador {

    public static boolean isValid(String cpf) {

        cpf = cpf.replace(".", "").replace("-", "");

        if (cpf == null || cpf.length() != 11) {
            return false;
        }

        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(cpf);
        if (!matcher.matches()) {
            return false;
        }

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
        if (secondDigit != Integer.parseInt(String.valueOf(cpf.charAt(10)))) {
            return false;
        }

        return true;
    }
}

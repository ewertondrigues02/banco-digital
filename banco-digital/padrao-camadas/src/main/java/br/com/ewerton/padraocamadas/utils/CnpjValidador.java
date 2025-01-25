package br.com.ewerton.padraocamadas.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CnpjValidador {

    public static boolean isValid(String cnpj) {
        cnpj = cnpj.replace(".", "").replace("-", "").replace("/", "");
        if (cnpj == null || cnpj.length() != 14) {
            return false;
        }

        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(cnpj);
        if (!matcher.matches()) {
            return false;
        }

        int sum = 0;
        int[] weight1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        for (int i = 0; i < 12; i++) {
            sum += Integer.parseInt(String.valueOf(cnpj.charAt(i))) * weight1[i];
        }
        int firstDigit = 11 - (sum % 11);
        if (firstDigit >= 10) {
            firstDigit = 0;
        }
        if (firstDigit != Integer.parseInt(String.valueOf(cnpj.charAt(12)))) {
            return false;
        }

        sum = 0;
        int[] weight2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        for (int i = 0; i < 13; i++) {
            sum += Integer.parseInt(String.valueOf(cnpj.charAt(i))) * weight2[i];
        }
        int secondDigit = 11 - (sum % 11);
        if (secondDigit >= 10) {
            secondDigit = 0;
        }
        if (secondDigit != Integer.parseInt(String.valueOf(cnpj.charAt(13)))) {
            return false;
        }

        try {
            Long cnpjAsLong = Long.parseLong(cnpj);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}
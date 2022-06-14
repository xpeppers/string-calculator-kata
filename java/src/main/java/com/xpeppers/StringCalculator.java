package com.xpeppers;

import java.util.Arrays;

public class StringCalculator {

    public static final int START_POSITION = 2;
    public static final String DEFAULT_DELIMITER = "\\n|";
    public static final int BIG_NUMBER = 1000;

    public int add(String input) {
        if (seInputVuoto(input))
            return 0;

        String delimiter = ",";

        if (input.startsWith("//")) {
            delimiter = getCustomDelimiter(input);
            input = getNumbersToSplit(input);
        }

        int[] numeri = Arrays.stream(input.split(DEFAULT_DELIMITER + delimiter)).mapToInt(num -> Integer.parseInt(num)).toArray();

        lanciaEccezioneSeEsistonoNumeriNegativi(numeri);

        return sommaNumeri(numeri);
    }

    private boolean seInputVuoto(String input) {
        return "".equals(input);
    }

    private int sommaNumeri(int[] numeri) {
        int result = 0;

        for (int numero : numeri) {
            if (numero < BIG_NUMBER)
                result += numero;
        }
        return result;
    }

    private void lanciaEccezioneSeEsistonoNumeriNegativi(int[] numeri) {

        String numeriNegativi = "";
        for (int numero : numeri) {
            if (numero < 0) {
                numeriNegativi += numero + ",";
            }
        }

        if (!seInputVuoto(numeriNegativi))
            throw new NumberFormatException("negatives not allowed: " + numeriNegativi.substring(0, numeriNegativi.length() - 1));
    }

    private String getNumbersToSplit(String input) {
        return input.substring(input.indexOf("\n") + 1);
    }

    private String getCustomDelimiter(String input) {
        return input.substring(START_POSITION, input.indexOf("\n"));
    }

}

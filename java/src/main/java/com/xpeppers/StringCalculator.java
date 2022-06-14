package com.xpeppers;

public class StringCalculator {

    public static final int START_POSITION = 2;
    public static final String DEFAULT_DELIMITER = "\\n|";

    public int add(String input) {
        if ("".equals(input))
            return 0;

        String delimiter = ",";

        if (input.startsWith("//")) {
            delimiter = getCustomDelimiter(input);
            input = getNumbersToSplit(input);
        }

        String[] numeri = input.split(DEFAULT_DELIMITER + delimiter);
        String numeriNegativi="";
        for (String numero : numeri) {
            int number = Integer.parseInt(numero);
            if (number < 0) {
                numeriNegativi += number+",";
            }
        }

        lanciaEccezioneSeEsistonoNumeriNegativi(numeriNegativi);

        int result = 0;

        for (String s : numeri) result += Integer.parseInt(s);

        return result;
    }

    private void lanciaEccezioneSeEsistonoNumeriNegativi(String numeriNegativi) {
        if (!"".equals(numeriNegativi))
            throw new NumberFormatException("negatives not allowed: " + numeriNegativi.substring(0, numeriNegativi.length()-1));
    }

    private String getNumbersToSplit(String input) {
        return input.substring(input.indexOf("\n") + 1);
    }

    private String getCustomDelimiter(String input) {
        return input.substring(START_POSITION, input.indexOf("\n"));
    }

}

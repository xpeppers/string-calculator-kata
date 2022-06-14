package com.xpeppers;

public class StringCalculator {

    public static final int START_POSITION = 2;
    public static final String N = "\\n|";

    public int add(String input) {
        if ("".equals(input))
            return 0;

        String delimiter = ",";

        if (input.startsWith("//")) {
            int finalPosition = input.indexOf("\n");
            delimiter = input.substring(START_POSITION, finalPosition);
            input = input.substring(finalPosition + 1);
        }

        String[] numeri = input.split(N + delimiter);

        for (String numero : numeri) {
            int number = Integer.parseInt(numero);
            if (number < 0) {
                throw new NumberFormatException("negatives not allowed: " + number);
            }
        }
        int result = 0;

        for (String s : numeri) result += Integer.parseInt(s);

        return result;
    }

}

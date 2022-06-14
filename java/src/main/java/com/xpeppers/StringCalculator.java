package com.xpeppers;

public class StringCalculator {

    public int add(String input) {

        if ("".equals(input))
            return 0;
        String delimiter = "";
        if (input.startsWith("//")) {
            int startPosition = 2;
            int finalPosition = input.indexOf("\n");

            delimiter = "|" + input.substring(startPosition, finalPosition);
            input = input.substring(finalPosition+1);

        }

        String[] numeri = input.split("\\n|," + delimiter);

        int result = 0;

        for (String s : numeri) result += Integer.parseInt(s);

        return result;
    }

}

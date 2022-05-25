package com.xpeppers;

public class StringCalculator {

    public int add(String input, String delimiter) {
        int result = 0;

        if ("".equals(input))
            return result;


        input = input.replaceAll("//", "");
        String[] numeri = input.split("\\n|" + delimiter);


        for (String s : numeri) result += Integer.parseInt(s);

        return result;
    }

}

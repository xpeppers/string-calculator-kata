package com.xpeppers;

public class StringCalculator {

    public int add(String input) {

        if ("".equals(input))
            return 0;

        String[] numeri = input.split(",");

        int result = 0;

        for (String s : numeri) result += Integer.parseInt(s);

        return result;
    }

}

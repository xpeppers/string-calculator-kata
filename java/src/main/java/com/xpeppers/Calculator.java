package com.xpeppers;

public class Calculator {

private static final String NUMBER_SEPARATOR=",";

    public static int add(String numbers){
        if (numbers.isEmpty())
            return 0;
        String[] number = numbers.split(NUMBER_SEPARATOR);
        return sumNumbers(number);
    }

    private static Integer sumNumbers(String[] numbers) {
        Integer result = 0;
        for (String number : numbers) {
            result += Integer.parseInt(number);
        }
        return result;
    }
}

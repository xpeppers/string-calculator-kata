package com.xpeppers;

public class Calculator {

private static final String NUMBER_SEPARATOR=",";

    public static int add(String numbers){
        if (numbers.isEmpty())
            return 0;
        String[] number = numbers.split(NUMBER_SEPARATOR);
        return sumNumbers(number);
    }

    private static Integer sumNumbers(String[] number) {
        Integer result = 0;
        for (int i = 0; i< number.length; i++){
            result = result + Integer.valueOf(number[i]);
        }
        return result;
    }
}

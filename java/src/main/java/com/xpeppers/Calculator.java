package com.xpeppers;

public class Calculator {

private static final String NUMBER_SEPARATOR=",";

    public static int add(String numbers){
        if (numbers.isEmpty())
            return 0;

        String[] number = numbers.split(NUMBER_SEPARATOR);
        Integer sum = 0;
        for (int i = 0; i< number.length; i++){
            sum = sum + Integer.valueOf(number[i]);
        }
        return sum;
    }
}

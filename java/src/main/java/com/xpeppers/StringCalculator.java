package com.xpeppers;

public class StringCalculator {
    public int add(String input) {
        if(input.isEmpty()) input="0";
        return Integer.parseInt(input);
    }
}

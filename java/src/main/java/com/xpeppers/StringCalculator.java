package com.xpeppers;

import java.util.Arrays;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.equals("")) {
            return 0;
        }
        return Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .mapToInt(Integer::intValue)
                .sum();
    }
}

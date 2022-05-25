package com.xpeppers;

import java.util.Arrays;

import static java.util.Arrays.*;

public class StringCalculator {

    public static final String COMMA = ",";
    public static final String NEW_LINE = "\n";
    public static final String EMPTY = "";

    public int add(String numbers) {
        if (numbers.equals(EMPTY)) {
            return 0;
        }
        return stream(createArrayOfNumbers(numbers))
                .map(Integer::parseInt)
                .mapToInt(Integer::intValue)
                .sum();
    }

    private String[] createArrayOfNumbers(String numbers) {
        return numbers.replaceAll(NEW_LINE, COMMA).split(COMMA);
    }
}

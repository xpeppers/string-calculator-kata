package com.xpeppers;

import static java.util.Arrays.*;

public class StringCalculator {

    public static final String COMMA = ",";
    public static final String NEW_LINE = "\n";
    public static final String EMPTY = "";
    public static final String DOUBLE_SLASH = "//";

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
        String delimiter = COMMA;
        if(numbers.contains(DOUBLE_SLASH)){
            delimiter = getCustomDelimiter(numbers);
            numbers = numbers.substring(numbers.indexOf('\n')+1);
        }
        return numbers.replaceAll(NEW_LINE, delimiter).split(delimiter);
    }

    private String getCustomDelimiter(String numbers) {
        return numbers.substring(calculateDelimiterStartPosition(numbers), numbers.indexOf('\n'));
    }

    private int calculateDelimiterStartPosition(String numbers) {
        return numbers.indexOf(DOUBLE_SLASH) + DOUBLE_SLASH.length();
    }
}

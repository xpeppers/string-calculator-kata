package com.xpeppers;

import static java.util.Arrays.*;


public class StringCalculator {

    public static final String COMMA = ",";
    public static final String NEW_LINE = "\n";
    public static final String EMPTY = "";
    public static final String DOUBLE_SLASH = "//";
    private final NegativeNumbersGuard negativeNumbersGuard;

    public StringCalculator(NegativeNumbersGuard negativeNumbersGuard) {
        this.negativeNumbersGuard = negativeNumbersGuard;
    }

    public int add(String numbers) {
        if (numbers.equals(EMPTY)) {
            return 0;
        }
        String[] arrayOfNumbers = createArrayOfNumbers(numbers);
        negativeNumbersGuard.checkNegativeNumbers(arrayOfNumbers);
        return stream(arrayOfNumbers)
                .map(Integer::parseInt)
                .mapToInt(Integer::intValue)
                .sum();
    }

    private String[] createArrayOfNumbers(String numbers) {
        String delimiter = COMMA;
        if(numbers.contains(DOUBLE_SLASH)){
            delimiter = getCustomDelimiter(numbers);
            numbers = stripDelimiterSpec(numbers);
        }
        return numbers.replaceAll(NEW_LINE, delimiter).split(delimiter);
    }

    private String stripDelimiterSpec(String numbers) {
        return numbers.substring(numbers.indexOf('\n') + 1);
    }

    private String getCustomDelimiter(String numbers) {
        return numbers.substring(calculateDelimiterStartPosition(numbers), numbers.indexOf('\n'));
    }

    private int calculateDelimiterStartPosition(String numbers) {
        return numbers.indexOf(DOUBLE_SLASH) + DOUBLE_SLASH.length();
    }
}

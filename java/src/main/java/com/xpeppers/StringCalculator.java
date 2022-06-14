package com.xpeppers;

import static java.util.Arrays.stream;


public class StringCalculator {

    public static final String COMMA = ",";
    public static final String NEW_LINE = "\n";
    public static final String EMPTY = "";
    public static final String DOUBLE_SLASH = "//";
    private final NegativeNumbersGuard negativeNumbersGuard;
    private final ILogger iLogger;
    private final IWebservice iWebservice;

    public StringCalculator(NegativeNumbersGuard negativeNumbersGuard, ILogger iLogger, IWebservice iWebservice) {
        this.negativeNumbersGuard = negativeNumbersGuard;
        this.iLogger = iLogger;
        this.iWebservice = iWebservice;
    }

    public int add(String numbers) {
        if (numbers.equals(EMPTY)) {
            return 0;
        }
        String[] arrayOfNumbers = createArrayOfNumbers(numbers);
        negativeNumbersGuard.checkNegativeNumbers(arrayOfNumbers);
        int sum = getSum(arrayOfNumbers);
        log(sum);
        return sum;
    }

    private void log(int sum) {
        try {
            iLogger.write(sum);
        } catch (Exception e) {
            iWebservice.msg(e.getMessage());
        }
    }

    private int getSum(String[] arrayOfNumbers) {
        return stream(arrayOfNumbers)
                .map(Integer::parseInt)
                .filter(currNumber -> currNumber < 1001)
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

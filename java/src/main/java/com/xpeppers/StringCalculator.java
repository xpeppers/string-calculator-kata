package com.xpeppers;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	public ILogger logger;

    public static int add(String stringOfNumbers) throws Exception {
        if (stringOfNumbers.isEmpty())
            return 0;

        String[] addends = split(stringOfNumbers);

        List<Integer> numbers = toIntegers(addends);

        List<Integer> negatives = negativesFrom(numbers);
        if (!negatives.isEmpty())
            throw new Exception("Negatives not allowed: " + join(negatives));

        return sum(numbers);
    }

    private static String[] split(String stringOfNumbers) {
        Pattern pattern = Pattern.compile("//(.+?)\n(.+)");
        Matcher matcher = pattern.matcher(stringOfNumbers);

        String delimiters = ",|\n";
        if (matcher.matches()) {
            String customDelimitersSection = matcher.group(1);
            delimiters = extractDelimitersFrom(customDelimitersSection);

            stringOfNumbers = matcher.group(2);
        }

        return stringOfNumbers.split(delimiters);
    }

    private static String extractDelimitersFrom(String delimiters) {
        List<String> allDelimiters = new ArrayList<String>();
        StringTokenizer tokenizer = new StringTokenizer(delimiters, "[]");
        while (tokenizer.hasMoreElements()) {
            String eachDelimiter = (String) tokenizer.nextElement();
            String quotedDelimiter = Pattern.quote(eachDelimiter);
            allDelimiters.add(quotedDelimiter);
        }

        return join(allDelimiters, "|");
    }

    private static List<Integer> toIntegers(String[] addends) {
        List<Integer> results = new ArrayList<Integer>();
        for (String addend : addends) {
            int number = Integer.parseInt(addend);
            results.add(number);
        }

        return results;
    }

    private static List<Integer> negativesFrom(List<Integer> numbers) {
        ArrayList<Integer> negatives = new ArrayList<Integer>();
        for (int n : numbers) {
            if (n < 0)
                negatives.add(n);
        }

        return negatives;
    }

    private static int sum(List<Integer> numbers) {
        int sum = 0;
        for (int n : numbers) {
            if (n < 1000)
                sum += n;
        }

        return sum;
    }

    private static String join(List<?> elements) {
        return join(elements, ", ");
    }

    private static String join(List<?> elements, String separator) {
        StringBuffer result = new StringBuffer();
        for (Object element : elements) {
            if (result.length() > 0) {
                result.append(separator);
            }
            result.append(element.toString());
        }
        return result.toString();
    }

}
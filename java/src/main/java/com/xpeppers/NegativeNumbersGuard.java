package com.xpeppers;

import java.util.ArrayList;
import java.util.List;

public class NegativeNumbersGuard {
    public void checkNegativeNumbers(String[] arrayOfNumbers) {
        List<String> negatives = new ArrayList<>();
        for (String number: arrayOfNumbers) {
            if (Integer.parseInt(number) < 0) {
                negatives.add(number);
            }
        }
        if (!negatives.isEmpty()) {
            String join = String.join(", ", negatives);
            throw new NegativeNumberException("negatives not allowed: " + join);
        }
    }
}

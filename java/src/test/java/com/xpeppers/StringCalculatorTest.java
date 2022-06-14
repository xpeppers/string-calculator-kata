package com.xpeppers;

import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {

    @Test
    public void emptyStringInput() {
        StringCalculator stringCalculator = new StringCalculator();

        int output = stringCalculator.add("");

        Assert.assertEquals(0, output);
    }

    @Test
    public void return1LikeResult() {
        StringCalculator stringCalculator = new StringCalculator();

        int output = stringCalculator.add("1");

        Assert.assertEquals(1, output);
    }

    @Test
    public void return3LikeResult() {
        StringCalculator stringCalculator = new StringCalculator();

        int output = stringCalculator.add("1,2");

        Assert.assertEquals(3, output);
    }

    @Test
    public void moreThanTwoInput() {
        StringCalculator stringCalculator = new StringCalculator();

        int output = stringCalculator.add("1,1,1,1,1");

        Assert.assertEquals(5, output);
    }

    @Test
    public void handleNewline() {
        StringCalculator stringCalculator = new StringCalculator();

        int output = stringCalculator.add("1\n2,3");

        Assert.assertEquals(6, output);
    }

    @Test
    public void handleSpecialCharacterThatIsNotDelimiter() {
        StringCalculator stringCalculator = new StringCalculator();

        int output = stringCalculator.add("//;\n1;2");

        Assert.assertEquals(3, output);
    }

    @Test
    public void throwExceptionIfNegativeNumbers() {
        StringCalculator stringCalculator = new StringCalculator();

        NumberFormatException numberFormatException = Assert.assertThrows( NumberFormatException.class, () -> {
            stringCalculator.add("1,4,-1");
        });

        Assert.assertEquals("negatives not allowed: -1", numberFormatException.getMessage());
    }

    @Test
    public void throwExceptionIfMoreNegativeNumbers() {
        StringCalculator stringCalculator = new StringCalculator();

        NumberFormatException numberFormatException = Assert.assertThrows(NumberFormatException.class, () -> {
            stringCalculator.add("-7,4,-1");
        });
        Assert.assertEquals("negatives not allowed: -7,-1", numberFormatException.getMessage());

    }

}

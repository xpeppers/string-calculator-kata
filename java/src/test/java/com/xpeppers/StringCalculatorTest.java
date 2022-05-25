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

}

package com.xpeppers;

import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {

    @Test
    public void should_return_0_when_empty_string() {
        StringCalculator stringCalculator = new StringCalculator();

        int result = stringCalculator.add("");

        Assert.assertEquals(result, 0);
    }

    @Test
    public void should_return_1_when_input_is_1() {
        StringCalculator stringCalculator = new StringCalculator();

        int result = stringCalculator.add("1");

        Assert.assertEquals(result, 1);
    }

    @Test
    public void should_return_3_when_input_is_1_comma_2() {
        StringCalculator stringCalculator = new StringCalculator();

        int result = stringCalculator.add("1,2");

        Assert.assertEquals(result, 3);
    }
}

package com.xpeppers;

import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {

    private final StringCalculator stringCalculator = new StringCalculator();

    @Test
    public void should_return_0_when_empty_string() {
        int result = stringCalculator.add("");

        Assert.assertEquals(result, 0);
    }

    @Test
    public void should_return_1_when_input_is_1() {
        int result = stringCalculator.add("1");

        Assert.assertEquals(result, 1);
    }

    @Test
    public void should_return_3_when_input_is_1_comma_2() {
        int result = stringCalculator.add("1,2");

        Assert.assertEquals(result, 3);
    }
    @Test
    public void should_return_sum_of_variabile_number_of_inputs() {
        int result = stringCalculator.add("1,2,3,4");

        Assert.assertEquals(result, 10);
    }
    @Test
    public void should_return_sum_of_variabile_number_of_inputs_with_newLine_symbol() {
        int result = stringCalculator.add("1\n2,3");

        Assert.assertEquals(result, 6);
    }
}

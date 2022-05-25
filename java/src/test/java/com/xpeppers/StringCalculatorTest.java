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

}

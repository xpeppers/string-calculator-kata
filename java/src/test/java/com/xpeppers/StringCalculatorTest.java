package com.xpeppers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {


    @Test
    public void add_stringa_vuota(){
        StringCalculator stringCalculator = new StringCalculator();
        int actual = stringCalculator.add("");

        assertEquals(0,actual);
    }
}

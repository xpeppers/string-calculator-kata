package com.xpeppers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void testThatEmptyEqualZero(){
        int result = Calculator.add("");
        assertEquals(0, result);
    }
}

package com.xpeppers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void testThatEmptyEqualZero(){
        int result = Calculator.add("");
        assertEquals(0, result);
    }

    @Test
    public void sumTwoNumbers(){
        int result = Calculator.add("1,2");
        assertEquals(3, result);
    }
    @Test
    public void testWithOneNumber(){
        int result = Calculator.add("1");
        assertEquals(1, result);
    }



}

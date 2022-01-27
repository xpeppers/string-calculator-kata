package com.xpeppers;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void addingEmptyStringReturnsZero() throws Exception {
        assertEquals(0, new StringCalculator().add(""));
    }

    @Test
    public void addingStringNumberReturnsNumber() throws Exception {
        assertEquals(1, new StringCalculator().add("1"));
    }

    @Test
    public void addingStringNumbersReturnsSum() throws Exception {
        assertEquals(7, new StringCalculator().add("1,2,4"));
    }

    @Test
    public void addingStringNumbersWithDelimitersReturnsSum() throws Exception {
        assertEquals(7, new StringCalculator().add("1\n2,4"));
    }

    @Test
    public void addingStringNumbersWithCustomDelimiterReturnsSum() throws Exception {
        assertEquals(3, new StringCalculator().add("//;\n1;2"));
    }

    @Test
    public void addingStringNumbersWithCustomDelimiterOfVariableLengthReturnsSum() throws Exception {
        assertEquals(6, new StringCalculator().add("//[***]\n1***2***3"));
    }

    @Test
    public void addingNegativeNumbersThrowsException() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage("Negatives not allowed: -1, -2");
        new StringCalculator().add("-1,1,-2");
    }

    @Test
    public void numberOverThousandAreIgnored() throws Exception {
        assertEquals(3, new StringCalculator().add("1,1001,2"));
    }

    @Test
    public void addingStringNumbersWithMultipleCustomDelimiterReturnsSum() throws Exception {
        assertEquals(6, new StringCalculator().add("//[%][*]\n1*2%3"));
    }

    @Test
    public void addingStringNumbersWithMultipleCustomDelimiterWithVariableLengthReturnsSum() throws Exception {
        assertEquals(6, new StringCalculator().add("//[%%][****]\n1****2%%3"));
    }

	@Test
	public void loggerInvoked() {

	}

}

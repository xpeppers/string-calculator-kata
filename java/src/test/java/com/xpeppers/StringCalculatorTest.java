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
        assertEquals(0, returnSum(""));
    }

    @Test
    public void addingStringNumberReturnsNumber() throws Exception {
        assertEquals(1, returnSum("1"));
    }

    @Test
    public void addingStringNumbersReturnsSum() throws Exception {
        assertEquals(7, returnSum("1,2,4"));
    }

    @Test
    public void addingStringNumbersWithDelimitersReturnsSum() throws Exception {
        assertEquals(7, returnSum("1\n2,4"));
    }

    @Test
    public void addingStringNumbersWithCustomDelimiterReturnsSum() throws Exception {
        assertEquals(3, returnSum("//;\n1;2"));
    }

    @Test
    public void addingStringNumbersWithCustomDelimiterOfVariableLengthReturnsSum() throws Exception {
        assertEquals(6, returnSum("//[***]\n1***2***3"));
    }

    @Test
    public void addingNegativeNumbersThrowsException() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage("Negatives not allowed: -1, -2");
        returnSum("-1,1,-2");
    }

    @Test
    public void numberOverThousandAreIgnored() throws Exception {
        assertEquals(3, returnSum("1,1001,2"));
    }

    @Test
    public void addingStringNumbersWithMultipleCustomDelimiterReturnsSum() throws Exception {
        assertEquals(6, returnSum("//[%][*]\n1*2%3"));
    }

    @Test
    public void addingStringNumbersWithMultipleCustomDelimiterWithVariableLengthReturnsSum() throws Exception {
        assertEquals(6, returnSum("//[%%][****]\n1****2%%3"));
    }

	private
	int returnSum(String textInput)
	throws Exception
	{
		return returnSum(textInput, new FakeLogger(), new FakeIWebservice());
	}

	private
	int returnSum(String textInput, final ILogger fakeLogger, final IWebservice fakeIWebservice)
	throws Exception
	{
		StringCalculator stringCalculator = new StringCalculator(fakeLogger, fakeIWebservice);
		return stringCalculator.add(textInput);
	}


	@Test
	public void logSum()
	throws Exception
	{
		FakeLogger fakeLogger = new FakeLogger();
		FakeIWebservice fakeIWebservice = new FakeIWebservice();
		returnSum("1,2,3", fakeLogger, fakeIWebservice);
		assertEquals(6, fakeLogger.getValue());
	}

	@Test
	public void notifyIwebserviceWhenError() throws Exception{
		final String errorMessage = "Errore di scrittura";
		FakeExceptionLogger fakeLogger = new FakeExceptionLogger(errorMessage);
		FakeIWebservice fakeIWebservice = new FakeIWebservice();
		returnSum("1,2,3", fakeLogger, fakeIWebservice);

		assertEquals(errorMessage, fakeIWebservice.getErrorMessage());
	}
}

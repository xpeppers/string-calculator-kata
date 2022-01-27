package com.xpeppers;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StringCalculatorTest {

	@Mock
	CustomLogger logger;

	@Mock
    CustomWebService webService;

	StringCalculator stringCalculator;

	@Before
	public void init() {
		this.stringCalculator = new StringCalculator(logger, webService);
	}

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void addingEmptyStringReturnsZero() throws Exception {
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void addingStringNumberReturnsNumber() throws Exception {
        assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    public void addingStringNumbersReturnsSum() throws Exception {
        assertEquals(7, stringCalculator.add("1,2,4"));
    }

    @Test
    public void addingStringNumbersWithDelimitersReturnsSum() throws Exception {
        assertEquals(7, stringCalculator.add("1\n2,4"));
    }

    @Test
    public void addingStringNumbersWithCustomDelimiterReturnsSum() throws Exception {
        assertEquals(3, stringCalculator.add("//;\n1;2"));
    }

    @Test
    public void addingStringNumbersWithCustomDelimiterOfVariableLengthReturnsSum() throws Exception {
        assertEquals(6, stringCalculator.add("//[***]\n1***2***3"));
    }

    @Test
    public void addingNegativeNumbersThrowsException() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage("Negatives not allowed: -1, -2");
        stringCalculator.add("-1,1,-2");
    }

    @Test
    public void numberOverThousandAreIgnored() throws Exception {
        assertEquals(3, stringCalculator.add("1,1001,2"));
    }

    @Test
    public void addingStringNumbersWithMultipleCustomDelimiterReturnsSum() throws Exception {
        assertEquals(6, stringCalculator.add("//[%][*]\n1*2%3"));
    }

    @Test
    public void addingStringNumbersWithMultipleCustomDelimiterWithVariableLengthReturnsSum() throws Exception {
        assertEquals(6, stringCalculator.add("//[%%][****]\n1****2%%3"));
    }

	@Test
	public void loggerInvoked()
	throws Exception
	{
		stringCalculator.add("1,2");
		verify(logger).write("The result is 3");
	}
	@Test()
	public void loggerFailNotifyException() throws Exception {
        doThrow(IllegalStateException.class)
                .when(logger)
                .write(anyString());
        stringCalculator.add("1,2");
        verify(webService).notifyException("CustomLogger Fail");
    }

}

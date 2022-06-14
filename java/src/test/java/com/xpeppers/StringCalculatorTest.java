package com.xpeppers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;
    private TestLogger testLogger;

    @Before
    public void init() {
        testLogger = new TestLogger();
        stringCalculator = new StringCalculator(new NegativeNumbersGuard(), testLogger, new TestIWebservice());
    }

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

    @Test
    public void should_return_sum_of_variabile_number_of_inputs_with_parametric_delimiter() {
        int result = stringCalculator.add("//;\n1;2");

        Assert.assertEquals(result, 3);
    }

    @Test
    public void should_throw_negative_numbers_exception_when_adding_negative_number() {
        NegativeNumberException exception = assertThrows(NegativeNumberException.class, () -> stringCalculator.add("1,4,-1"));
        Assert.assertEquals("negatives not allowed: -1", exception.getMessage());
    }

    @Test
    public void should_ignore_numbers_obove_1000_and_return_sum_numbers() {
        int result = stringCalculator.add("1001,2");
        Assert.assertEquals(2, result);
    }

    @Test
    public void should_log_add_method_sum() {
        int result = stringCalculator.add("1001,2");
        String actual = testLogger.getPrinted();

        Assert.assertEquals("2",actual);
    }
    @Test
    public void should_notify_to_i_IWebservice_when_logger_throws_exception() {
        TestIWebservice iWebservice = new TestIWebservice();
        stringCalculator = new StringCalculator(new NegativeNumbersGuard(), new TestExceptionLogger(),iWebservice);
        stringCalculator.add("1001,2");
        assertTrue(iWebservice.hasNotified());

    }
}

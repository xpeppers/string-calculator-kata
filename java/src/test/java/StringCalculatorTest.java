import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class StringCalculatorTest {

    private final ILogger iLogger=mock(ILogger.class);

    private final StringCalculator stringCalculator = new StringCalculator(iLogger);

    @Test
    public void empty_string_return_0() {
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void string_with_one_number_return_number() {
        assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    public void string_with_2_parameters_return_sum_of_them() {
        assertEquals(3, stringCalculator.add("1,2"));
    }

    @Test
    public void string_with_3_parameters_return_sum_of_them() {
        assertEquals(6, stringCalculator.add("1,2,3"));
    }

    @Test
    public void string_with_new_line_as_separator() {
        assertEquals(6, stringCalculator.add("1\n2,3"));
    }

    @Test
    public void custom_delimiter() {
        assertEquals(3, stringCalculator.add("//;\n1;2"));
    }

    @Test
    public void should_throw_exception_when_negatives_in_input() {
        String input = "//;\n-1;1;2";
        NumberFormatException numberFormatException = assertThrows(NumberFormatException.class, () -> stringCalculator.add(input));
        assertEquals("negatives not allowed: -1", numberFormatException.getMessage());
    }

    @Test
    public void should_throw_exception_when_there_many_negatives_in_input() {
        String input = "//;\n-1;-3;1;-2";
        NumberFormatException numberFormatException = assertThrows(NumberFormatException.class, () -> stringCalculator.add(input));
        assertEquals("negatives not allowed: -1 -3 -2", numberFormatException.getMessage());
    }

    @Test
    public void should_ignore_big_number() {
        assertEquals(2, stringCalculator.add("//;\n1001;2"));
    }

    @Test
    public void should_not_ignore_1000() {
        assertEquals(1002, stringCalculator.add("//;\n1000;2"));
    }

    @Test
    public void should_log() {
        int somma = stringCalculator.add("1,2");
        verify(iLogger).log(somma);
    }

    @Test
    public void should_log_also_with_empty_string() {
        int somma = stringCalculator.add("");
        verify(iLogger).log(somma);
    }
}
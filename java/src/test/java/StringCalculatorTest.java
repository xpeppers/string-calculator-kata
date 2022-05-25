import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {
    private final StringCalculator stringCalculator=new StringCalculator();

    @Test
    public void empty_string_return_0(){
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void string_with_one_number_return_number(){
        assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    public void string_with_2_parameters_return_sum_of_them(){
        assertEquals(3, stringCalculator.add("1,2"));
    }

    @Test
    public void string_with_3_parameters_return_sum_of_them(){
        assertEquals(6, stringCalculator.add("1,2,3"));
    }
}
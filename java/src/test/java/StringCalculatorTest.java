import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {
    private final StringCalculator stringCalculator=new StringCalculator();
    /*    Step 1: the simplest thing
    Create a simple String calculator with a method int add(String numbers).

    The string argument can contain 0, 1 or 2 numbers, and will return their sum (for an empty string it will return 0) for example "" or "1" or "1,2".
    Start with the simplest test case of an empty string and move to 1 and two numbers.
    Remember to solve things as simply as possible so that you force yourself to write tests you did not think about.
    Remember to refactor after each passing test.*/

    @Test
    public void empty_string_return_0(){
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void string_with_one_number_return_number(){
        assertEquals(1, stringCalculator.add("1"));
    }

}
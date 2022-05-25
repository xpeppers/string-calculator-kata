import static java.lang.Integer.parseInt;

public class StringCalculator {

    public static final String EMPTY_STRING = "";

    public int add(String input) {
        if(input.equals(EMPTY_STRING))
            return 0;
        return parseInt(input);
    }
}

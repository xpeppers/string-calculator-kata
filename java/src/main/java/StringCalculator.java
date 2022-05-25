import static com.sun.deploy.util.StringUtils.splitString;
import static java.util.Arrays.stream;

public class StringCalculator {

    public static final String EMPTY_STRING = "";

    public int add(String input) {
        if (input.equals(EMPTY_STRING))
            return 0;
        String delimiter=",";
        if(input.startsWith("//")) {
            delimiter = input.substring(2, 3);
            input=input.substring(4);
        }
        String[] lista = splitString(input.replace("\n", ","), delimiter);
        return stream(lista).mapToInt(Integer::parseInt).sum();
    }
}

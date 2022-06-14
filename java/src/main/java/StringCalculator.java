import static com.sun.deploy.util.StringUtils.splitString;
import static java.util.Arrays.stream;

public class StringCalculator {

    private static final String EMPTY_STRING = "";
    private String DELIMITER = ",";
    private String negatives = EMPTY_STRING;
    private final ILogger iLogger;

    public StringCalculator(ILogger iLogger) {
        this.iLogger = iLogger;
    }

    public int add(String input) {
        int sum = calculateSum(input);
        throwIfNegativesWereFound();
        iLogger.log(sum);
        return sum;
    }

    private int calculateSum(String input) {
        if (input.equals(EMPTY_STRING))
            return 0;
        return stream(split(parse(input)))
                .mapToInt(Integer::parseInt)
                .filter(s -> s <= 1000)
                .map(this::appendIfNegative)
                .sum();
    }

    private void throwIfNegativesWereFound() {
        if (!negatives.isEmpty()) {
            throw new NumberFormatException("negatives not allowed:" + negatives);
        }
    }

    private String[] split(String input) {
        return splitString(input.replace("\n", ","), DELIMITER);
    }

    private int appendIfNegative(int s) {
        if (s < 0)
            negatives = negatives.concat(" " + s);
        return s;
    }

    private String parse(String input) {
        if (hasCustomDelimiter(input)) {
            DELIMITER = input.substring(2, 3);
            input = input.substring(4);
        }
        return input;
    }

    private boolean hasCustomDelimiter(String input) {
        return input.startsWith("//");
    }
}

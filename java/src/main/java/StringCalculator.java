import com.sun.deploy.util.StringUtils;

import static java.lang.Integer.parseInt;

public class StringCalculator {

    public static final String EMPTY_STRING = "";

    public int add(String input) {
        if(input.equals(EMPTY_STRING))
            return 0;
        String[] lista = StringUtils.splitString(input, ",");
        int sum=0;
        for(String elem: lista){
            sum+=parseInt(elem);
        }
        return sum;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * https://open.kattis.com/problems/t9spelling
 */
public class T9Spelling {

    private static final String[] dialPad = new String[128];
    static {
        dialPad[' '] = "0";
        dialPad['a'] = "2";
        dialPad['b'] = "22";
        dialPad['c'] = "222";
        dialPad['d'] = "3";
        dialPad['e'] = "33";
        dialPad['f'] = "333";
        dialPad['g'] = "4";
        dialPad['h'] = "44";
        dialPad['i'] = "444";
        dialPad['j'] = "5";
        dialPad['k'] = "55";
        dialPad['l'] = "555";
        dialPad['m'] = "6";
        dialPad['n'] = "66";
        dialPad['o'] = "666";
        dialPad['p'] = "7";
        dialPad['q'] = "77";
        dialPad['r'] = "777";
        dialPad['s'] = "7777";
        dialPad['t'] = "8";
        dialPad['u'] = "88";
        dialPad['v'] = "888";
        dialPad['w'] = "9";
        dialPad['x'] = "99";
        dialPad['y'] = "999";
        dialPad['z'] = "9999";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in), 8092);
        int testCasesCount = Integer.parseInt(in.readLine());
        for (int t = 0; t < testCasesCount; t++) {
            System.out.println(String.format("Case #%d: %s", t + 1, translate(in.readLine())));
        }
    }


    public static String translate(String plainText) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            String token = dialPad[plainText.charAt(i)];
            if (result.length() > 0 && result.charAt(result.length() - 1) == token.charAt(0)) {
                result.append(" ");
            }
            result.append(token);
        }
        return result.toString();
    }
}

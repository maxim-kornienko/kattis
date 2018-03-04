import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://open.kattis.com/problems/simon
 */
public class SimonSays {
    private static String MAGIC_WORD = "simon says ";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int testCasesCount = Integer.parseInt(in.readLine());
        for (int t = 0; t < testCasesCount; t++) {
            String phrase = in.readLine();
            System.out.println(getCommand(phrase));
        }
    }

    public static String getCommand(String phrase) {
        int pos = phrase.indexOf(MAGIC_WORD);
        if (pos == -1)
            return "";
        return phrase.substring(pos + MAGIC_WORD.length());
    }

}

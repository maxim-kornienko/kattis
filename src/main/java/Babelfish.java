import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * https://open.kattis.com/problems/babelfish
 */
public class Babelfish {

    private static final String EH = "eh";

    private final Map<String, String> dictionary = new HashMap<>(100000);

    public void remember(String word, String translation) {
        dictionary.put(word, translation);
    }

    public String translate(String word) {
        String translation = dictionary.get(word);
        return translation == null ? EH : translation;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in), 1024 * 1024);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        Babelfish babelfish = new Babelfish();

        String line = in.readLine();
        while (line.length() > 0) {
            int pos = line.indexOf(' ');
            babelfish.remember(line.substring(pos + 1, line.length()), line.substring(0, pos));
            line = in.readLine();
        }

        line = in.readLine();
        while (line != null) {
            out.print(babelfish.translate(line));
            out.print("\n");
            line = in.readLine();
        }

        out.flush();
    }

}

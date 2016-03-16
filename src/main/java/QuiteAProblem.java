import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://open.kattis.com/problems/quiteaproblem
 */
public class QuiteAProblem {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String line = in.readLine();
        while (line != null) {
            line = line.toLowerCase();
            if (line.contains("problem")) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
            line = in.readLine();
        }
    }
}

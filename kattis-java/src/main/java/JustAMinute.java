import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://open.kattis.com/problems/justaminute
 */
public class JustAMinute {

    static final double ERROR = Math.pow(10, -7);

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int observationsCount = Integer.parseInt(in.readLine());
        int minutes = 0;
        int seconds = 0;
        for (int i = 0; i < observationsCount; i++) {
            String[] observation = in.readLine().split(" ");
            minutes += Integer.parseInt(observation[0]);
            seconds += Integer.parseInt(observation[1]);
        }
        double result = seconds / (minutes * 60.0);
        if (result <= (1 + ERROR)) {
            System.out.println("measurement error");
        } else {
            System.out.println(result);
        }

    }
}

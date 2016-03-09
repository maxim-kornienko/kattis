import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://open.kattis.com/problems/conundrum
 */
public class CryptographersConundrum {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String cipher = in.readLine();
        int days = 0;
        char[] per = {'P', 'E', 'R'};
        for (int i = 0; i < cipher.length(); i++) {
            if (per[i % 3] != cipher.charAt(i))
                days++;
        }
        System.out.println(days);
    }
}

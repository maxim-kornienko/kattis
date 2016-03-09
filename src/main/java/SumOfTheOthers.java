import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/sumoftheothers
 */
public class SumOfTheOthers {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();
        while (line != null) {
            Scanner sc = new Scanner(line);
            long sum = 0;
            while (sc.hasNext()) {
                sum += sc.nextInt();
            }
            System.out.println(sum / 2);
            line = in.readLine();
        }
    }
}

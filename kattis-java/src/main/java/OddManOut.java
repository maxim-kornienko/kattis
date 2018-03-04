import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/oddmanout
 */
public class OddManOut {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));


        int testCasesCount = sc.nextInt();
        for (int t = 0; t < testCasesCount; t++) {
            long result = 0;

            int guests = sc.nextInt();
            for (int g = 0; g < guests; g++) {
                int code = sc.nextInt();
                result ^= code;
            }

            System.out.printf("Case #%d: %d\n", t + 1, result);
        }
    }
}

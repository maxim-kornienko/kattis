import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/cold
 */
public class ColdputerScience {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = sc.nextInt();

        int belowZero = 0;
        for (int i = 0; i < n; i++) {
            if (sc.nextInt() < 0)
                belowZero++;
        }
        System.out.println(belowZero);
    }
}

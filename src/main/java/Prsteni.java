import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/prsteni
 */
public class Prsteni {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();

        int up = 1;
        int down = 1;
        int prevRing = sc.nextInt();

        for (int i = 1; i < n; i++) {
            int curRing = sc.nextInt();

            up *= prevRing;
            down *= curRing;

            int gcd = gcd(up, down);

            up /= gcd;
            down /= gcd;

            System.out.println(String.format("%d/%d", up, down));

            prevRing = curRing;
        }
    }

    private static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}

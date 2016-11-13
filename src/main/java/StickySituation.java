import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/stickysituation
 */
public class StickySituation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));

        int n = sc.nextInt();
        long[] sticks = new long[n];
        for (int i = 0; i < sticks.length; i++) {
            sticks[i] = sc.nextLong();
        }

        Arrays.sort(sticks);

        for (int i = 0; i < sticks.length - 2; i++) {
            if (sticks[i] + sticks[i + 1] > sticks[i + 2]) {
                System.out.println("possible");
                return;
            }
        }
        System.out.println("impossible");
    }
}

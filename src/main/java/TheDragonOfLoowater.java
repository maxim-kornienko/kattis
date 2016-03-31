import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/loowater
 */
public class TheDragonOfLoowater {

    private static int LOOWATER_IS_DOOMED = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));

        int headsCount = sc.nextInt();
        int knightsCount = sc.nextInt();
        while (headsCount != 0 && knightsCount != 0) {
            int[] heads = new int[headsCount];
            Arrays.setAll(heads, i -> sc.nextInt());

            int[] knights = new int[knightsCount];
            Arrays.setAll(knights, i -> sc.nextInt());

            long pay = match(heads, knights);
            if (pay == LOOWATER_IS_DOOMED) {
                System.out.println("Loowater is doomed!");
            } else {
                System.out.println(pay);
            }

            headsCount = sc.nextInt();
            knightsCount = sc.nextInt();
        }
    }

    public static long match(int[] heads, int[] knights) {
        Arrays.sort(heads);
        Arrays.sort(knights);
        int h = 0;
        int k = 0;
        long pay = 0;
        while (h < heads.length && k < knights.length) {
            if (heads[h] > knights[k]) {
                k++;
                continue;
            }
            pay += knights[k];
            k++;
            h++;
        }
        if (h != heads.length && k == knights.length)
            return LOOWATER_IS_DOOMED;

        return pay;
    }
}

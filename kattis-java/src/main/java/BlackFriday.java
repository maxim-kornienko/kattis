import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/blackfriday
 */
public class BlackFriday {

    private static final int UNDEFINED = -1;
    private static final int NOT_UNIQUE = -2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int groupSize = sc.nextInt();

        int[] rolls = new int[6];
        Arrays.fill(rolls, UNDEFINED);
        for (int i = 0; i < groupSize; i++) {
            int roll = sc.nextInt();
            if (rolls[roll - 1] == UNDEFINED) {
                rolls[roll - 1] = i + 1;
            } else {
                rolls[roll - 1] = NOT_UNIQUE;
            }
        }
        for (int r = rolls.length - 1; r >= 0; r--) {
            if (rolls[r] != UNDEFINED && rolls[r] != NOT_UNIQUE) {
                System.out.println(rolls[r]);
                return;
            }
        }
        System.out.println("none");
    }
}

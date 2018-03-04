import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/textmessaging
 */
public class TextMessagingOutrage {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));

        int testCasesCount = sc.nextInt();
        for (int t = 0; t < testCasesCount; t++) {
            int lettersOnKey = sc.nextInt();
            int keysCount = sc.nextInt();
            int lettersCount = sc.nextInt();
            int[] letters = new int[lettersCount];
            for (int i = 0; i < lettersCount; i++) {
                letters[i] = sc.nextInt();
            }

            Arrays.sort(letters);
            long totalKeyPresses = 0;
            for (int i = letters.length - 1; i >= 0; i--) {
                int keyPressFactor = (letters.length - 1 - i) / keysCount + 1;
                totalKeyPresses += letters[i] * keyPressFactor;
            }
            System.out.printf("Case #%d: %d", t + 1, totalKeyPresses);
            System.out.println();
        }
    }
}

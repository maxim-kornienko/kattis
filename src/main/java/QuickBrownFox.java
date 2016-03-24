import java.io.BufferedInputStream;
import java.util.BitSet;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/quickbrownfox
 */
public class QuickBrownFox {

    private static final int BITS = 'z' - 'a' + 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int testCasesCount = Integer.parseInt(sc.nextLine());

        for (int t = 0; t < testCasesCount; t++) {
            String line = sc.nextLine().toLowerCase();
            BitSet set = new BitSet(BITS);
            for (int i = 0; i < line.length(); i++) {
                int code = line.charAt(i) - 'a';
                if (code >= 0 && code < BITS) {
                    set.set(code);
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < BITS; i++) {
                if (!set.get(i)) {
                    char c = (char) ('a' + i);
                    sb.append(c);
                }
            }
            if (sb.length() == 0) {
                System.out.println("pangram");
            } else {
                System.out.println("missing " + sb.toString());
            }
        }
    }
}

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/closingtheloop
 */
public class ClosingTheLoop {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));

        int testCasesCount = Integer.parseInt(sc.nextLine());
        for (int t = 0; t < testCasesCount; t++) {
            int segmentsCount = Integer.parseInt(sc.nextLine());
            String[] segments = sc.nextLine().split(" ");

            int[] blue = new int[segmentsCount];
            int[] red = new int[segmentsCount];

            for (int s = 0; s < segmentsCount; s++) {
                String seg = segments[s];
                if (seg.charAt(seg.length() - 1) == 'B') {
                    blue[s] = Integer.parseInt(seg.substring(0, seg.length() - 1));
                } else {
                    red[s] = Integer.parseInt(seg.substring(0, seg.length() - 1));
                }
            }
            Arrays.sort(blue);
            Arrays.sort(red);

            int iBlue = blue.length;
            int iRed = red.length;
            long length = 0;
            while (blue[--iBlue] > 0 && red[--iRed] > 0) {
                length += blue[iBlue] + red[iRed] - 2;
            }
            System.out.printf("Case #%d: %d" + System.lineSeparator(), t + 1, length);
        }
    }
}

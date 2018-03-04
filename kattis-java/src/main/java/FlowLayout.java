import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/flowlayout
 */
public class FlowLayout {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int maxWidth = sc.nextInt();
        while (maxWidth > 0) {
            int rowWidth = 0;
            int rowHeight = 0;

            int windowWidth = 0;
            int windowHeight = 0;

            int compWidth = sc.nextInt();
            int compHeight = sc.nextInt();

            while (compWidth > 0 && compHeight > 0) {
                if (rowWidth + compWidth <= maxWidth) {
                    rowWidth += compWidth;
                    rowHeight = Math.max(rowHeight, compHeight);
                } else {
                    windowWidth = Math.max(windowWidth, rowWidth);
                    windowHeight += rowHeight;

                    rowWidth = compWidth;
                    rowHeight = compHeight;
                }

                compWidth = sc.nextInt();
                compHeight = sc.nextInt();
            }
            windowWidth = Math.max(windowWidth, rowWidth);
            windowHeight += rowHeight;

            System.out.printf("%d x %d\n", windowWidth, windowHeight);

            maxWidth = sc.nextInt();
        }
    }
}

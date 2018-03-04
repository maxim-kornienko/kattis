import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/friday
 */
public class FridayTheThirteenth {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));

        int testCasesCount = sc.nextInt();
        for (int t = 0; t < testCasesCount; t++) {
            int daysInAYear = sc.nextInt();
            int months = sc.nextInt();
            int daysInPreviousMonths = 0;
            int fridaysThe13th = 0;
            for (int m = 0; m < months; m++) {
                int daysInCurrentMonth = sc.nextInt();
                if (daysInCurrentMonth >= 13 && (daysInPreviousMonths + 13) % 7 == 6)
                    fridaysThe13th++;
                daysInPreviousMonths += daysInCurrentMonth;
            }
            System.out.println(fridaysThe13th);
        }
    }
}

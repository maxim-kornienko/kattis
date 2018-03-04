import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/detaileddifferences
 */
public class DetailedDifferences {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int testCasesCount = Integer.parseInt(sc.nextLine());

        for (int t = 0; t < testCasesCount; t++) {
            String lineA = sc.nextLine();
            String lineB = sc.nextLine();

            System.out.println(lineA);
            System.out.println(lineB);
            for (int i = 0; i < lineA.length(); i++) {
                if (lineA.charAt(i) == lineB.charAt(i)) {
                    System.out.print('.');
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
            System.out.println();
        }
    }
}
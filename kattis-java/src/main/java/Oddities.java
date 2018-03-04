import java.util.Scanner;

/**
 * https://open.kattis.com/problems/oddities
 */
public class Oddities {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int testCasesCount = s.nextInt();
        for (int t = 0; t < testCasesCount; t++) {
            int number = s.nextInt();
            if (number % 2 == 0) {
                System.out.println(number + " is even");
            } else {
                System.out.println(number + " is odd");
            }
        }
    }
}

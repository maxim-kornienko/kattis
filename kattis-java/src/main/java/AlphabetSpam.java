import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/alphabetspam
 */
public class AlphabetSpam {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));

        char[] line = sc.nextLine().toCharArray();
        int whitespace = 0;
        int lowercase = 0;
        int uppercase = 0;
        int others = 0;
        for (char c : line) {
            if (c == '_') {
                whitespace++;
            } else if (Character.isLowerCase(c)) {
                lowercase++;
            } else if (Character.isUpperCase(c)) {
                uppercase++;
            } else {
                others++;
            }
        }
        outputRatio(whitespace, line.length);
        outputRatio(lowercase, line.length);
        outputRatio(uppercase, line.length);
        outputRatio(others, line.length);
    }

    private static void outputRatio(int group, int total) {
        System.out.println((double) group / total);
    }
}

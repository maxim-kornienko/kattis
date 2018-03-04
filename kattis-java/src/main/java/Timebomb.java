import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/timebomb
 */
public class Timebomb {

    private static String DIGITS =
            "***   * *** *** * * *** *** *** *** ***\n" +
            "* *   *   *   * * * *   *     * * * * *\n" +
            "* *   * *** *** *** *** ***   * *** ***\n" +
            "* *   * *     *   *   * * *   * * *   *\n" +
            "***   * *** ***   * *** ***   * *** ***";

    private static String[] CONVERTER = separateDigits(DIGITS).toArray(new String[10]);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append(sc.nextLine());
            sb.append('\n');
        }

        List<String> code = separateDigits(sb.toString());
        int c = 0;
        int pow = 1;
        for (int i = code.size() - 1; i >= 0; i--) {
            int digit = -1;
            for (int j = 0; j < CONVERTER.length; j++) {
                if (CONVERTER[j].equals(code.get(i))) {
                    digit = j;
                    break;
                }
            }
            if (digit == -1) {
                System.out.println("BOOM!!");
                return;
            }
            c += digit * pow;
            pow *= 10;
        }
        System.out.println(c % 6 == 0 ? "BEER!!" : "BOOM!!");
    }

    private static List<String> separateDigits(String string) {
        List<StringBuilder> builders = new ArrayList<>();
        Scanner scanner = new Scanner(string);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            for (int i = 0; i < line.length(); i++) {
                if (builders.size() == i / 4)
                    builders.add(new StringBuilder());
                if (i % 4 == 3)
                    continue;
                builders.get(i / 4).append(line.charAt(i));
            }
        }

        List<String> result = new ArrayList<>();

        for (StringBuilder b : builders) {
            result.add(b.toString());
        }
        return result;
    }

    /*private static void printDigit(String d) {
        for (int i = 0; i < d.length(); i++) {
            if (i %3 == 0)
                System.out.println();
            System.out.print(d.charAt(i));
        }
    }*/
}

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/veci
 */
public class Veci {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        for (int i = line.length() - 1; i >= 0; i--) {
            char digitI = line.charAt(i);

            for (int j = i - 1; j >= 0; j--) {
                char digitJ = line.charAt(j);
                if (digitI > digitJ) {
                    char[] chars = new char[line.length()];
                    line.getChars(0, chars.length, chars, 0);
                    chars[i] = digitJ;
                    chars[j] = digitI;
                    Arrays.sort(chars, j + 1, chars.length);
                    System.out.println(String.valueOf(chars));
                    return;
                }
            }
        }
        System.out.println("0");
    }
}

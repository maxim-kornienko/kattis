import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/backspace
 */
public class Backspace {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        String line = sc.nextLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '<') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(c);
            }
        }
        System.out.println(sb);
    }
}

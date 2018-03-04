import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/secretmessage
 */
public class SecretMessage {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int testCasesCount = Integer.parseInt(sc.nextLine());
        for (int t = 0; t < testCasesCount; t++) {
            System.out.println(encode(sc.nextLine()));
        }
    }

    private static String encode(String message) {
        return convert(rotateClockwise(convert(message)));
    }

    private static char[][] convert(String message) {
        int n = (int) Math.sqrt(message.length());

        if (n * n != message.length()) {
            n += 1;
        }

        char[][] table = new char[n][n];
        for (int i = 0; i < n * n; i++) {
            table[i % n][i / n] = i < message.length() ? message.charAt(i) : '*';
        }
        return table;
    }

    private static String convert(char[][] table) {
        StringBuilder message = new StringBuilder(table.length * table.length);
        for (int j = 0; j < table.length; j++) {
            for (int i = 0; i < table.length; i++) {
                if (table[i][j] != '*')
                    message.append(table[i][j]);
            }
        }
        return message.toString();
    }

    private static char[][] rotateClockwise(char[][] table) {
        char[][] rotated = new char[table.length][table.length];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                rotated[table.length - 1 - j][i] = table[i][j];
            }
        }
        return rotated;
    }
}

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/tajna
 */
public class Tajna {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        String message = sc.nextLine();
        System.out.println(readRowMajor(writeColumnMajor(message)));
    }

    private static int getRowsCount(int n) {
        for (int i = (int) Math.sqrt(n); i > 0; i--) {
            if (n % i == 0)
                return i;
        }
        return n;
    }

    private static char[][] writeColumnMajor(String message) {
        int rows = getRowsCount(message.length());
        int columns = message.length() / rows;

        char[][] matrix = new char[rows][columns];
        for (int i = 0; i < message.length(); i++) {
            matrix[i % matrix.length][i / matrix.length] = message.charAt(i);
        }
        return matrix;
    }

    private static String readRowMajor(char[][] matrix) {
        StringBuilder buider = new StringBuilder();
        for (int i = 0 ; i < matrix.length; i++) {
            buider.append(matrix[i]);
        }
        return buider.toString();
    }
}

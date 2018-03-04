import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/bishops
 */
public class Bishops {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        while (sc.hasNextLine()) {
            int n = Integer.parseInt(sc.nextLine());
            if (n == 1) {
                System.out.println(1);
            } else {
                System.out.println(n * 2 - 2);
            }
        }
    }
}

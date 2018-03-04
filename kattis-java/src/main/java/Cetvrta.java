import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/cetvrta
 */
public class Cetvrta {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int x = 0;
        int y = 0;
        for (int i = 0; i < 3; i++) {
            x ^= sc.nextInt();
            y ^= sc.nextInt();
        }
        System.out.printf("%d %d\n", x, y);
    }
}

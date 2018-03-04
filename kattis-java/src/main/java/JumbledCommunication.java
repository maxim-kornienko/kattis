import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/communication
 */
public class JumbledCommunication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print(unscramble(sc.nextInt()));
            System.out.print(' ');
        }
    }

    public static int unscramble(int b) {
        int r = 0;

        int mask = 1;
        for (int i = 0; i < 8; i++) {
            int nextBit = (b ^ r ) & mask;
            r |= nextBit << 1;
            mask = mask << 1;
        }

        return r >> 1;
    }
}

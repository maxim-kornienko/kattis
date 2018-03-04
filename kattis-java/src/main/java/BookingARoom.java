import java.io.BufferedInputStream;
import java.util.BitSet;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/bookingaroom
 */
public class BookingARoom {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        short r = sc.nextShort();
        short n = sc.nextShort();

        BitSet hotel = new BitSet(r + 1);
        for (int i = 0; i < n; i++) {
            hotel.set(sc.nextShort());
        }
        for (int i = 1; i < r + 1; i++) {
            if (!hotel.get(i)) {
                System.out.println(i);
                return;
            }
        }
        System.out.println("too late");
    }
}

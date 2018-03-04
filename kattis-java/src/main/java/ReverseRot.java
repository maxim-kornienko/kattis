import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/reverserot
 */
public class ReverseRot {

    private static char[] TABLE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ_.".toCharArray();
    private static byte[] MAP = new byte[Byte.MAX_VALUE];
    static {
      for (byte i = 0; i < TABLE.length; i++) {
          MAP[TABLE[i]] = i;
      }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));

        int shift = sc.nextInt();
        while (shift != 0) {
            String text =  sc.nextLine();
            System.out.println(encode(shift, text));
            shift = sc.nextInt();
        }

    }

    private static String encode(int shift, String text) {
        StringBuilder builder = new StringBuilder(text.length());
        for (int i = text.length() - 1; i > 0; i-- ) {
            builder.append(TABLE[(MAP[text.charAt(i)] + shift) % TABLE.length]);
        }
        return builder.toString();
    }
}

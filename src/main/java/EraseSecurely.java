import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * https://open.kattis.com/problems/erase
 */
public class EraseSecurely{

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        String before = in.readLine();
        String after = in.readLine();

        boolean failed;
        if (n % 2 == 0) {
            failed = !Objects.equals(before, after);
        } else {
            failed = false;
            for (int i = 0; i < before.length(); i++) {
                if (before.charAt(i) == after.charAt(i)) {
                    failed = true;
                    break;
                }
            }
        }
        if (failed) {
            System.out.println("Deletion failed");
        } else {
            System.out.println("Deletion succeeded");
        }
    }
}

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/hidden
 */
public class HiddenPassword {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        String[] line = sc.nextLine().split(" ");
        String password = line[0];
        String message = line[1];

        int k = 0;
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == password.charAt(k)) {
                k++;
                if (k == password.length()) {
                    System.out.println("PASS");
                    return;
                }
            } else {
                for (int j = k + 1; j < password.length(); j++) {
                    if (message.charAt(i) == password.charAt(j)) {
                        System.out.println("FAIL");
                        return;
                    }
                }
            }
        }
        System.out.println("FAIL");
    }
}

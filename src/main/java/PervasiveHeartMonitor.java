import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/pervasiveheartmonitor
 */
public class PervasiveHeartMonitor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));

        while (sc.hasNext()) {
            String line = sc.nextLine();
            StringBuilder name = new StringBuilder();
            double sum = 0.0;
            int num = 0;

            for (String token : line.split(" ")) {
                if (Character.isLetter(token.charAt(0))) {
                    name.append(token).append(' ');
                    continue;
                }
                sum += Double.parseDouble(token);
                num++;
            }

            System.out.printf("%f %s\n", sum / num, name.substring(0, name.length() - 1));
        }
    }
}

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/server
 */
public class Server {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        int totalTime = sc.nextInt();

        int i = 0;
        while (i < n) {
            int taskTime = sc.nextInt();
            totalTime -= taskTime;
            if (totalTime < 0)
                break;
            i++;
        }

        System.out.println(i);
    }

}

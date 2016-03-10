import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/bus
 */
public class Bus {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in), 1024 * 1024));

        int testCasesCount = sc.nextInt();
        for (int t = 0; t < testCasesCount; t++) {
            int k = sc.nextInt();
            System.out.println(getInitialPassengersCount(k));
        }
    }

    public static int getInitialPassengersCount(int stopsCount) {
        // let's multiply all absolute values by 2 to solve in whole numbers instead of dealing with 'half a passenger'
        int passengers = 2;
        for (int i = 1; i < stopsCount; i++) {
            passengers += 1;
            passengers *= 2;
        }
        return passengers / 2;
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/commercials
 * This is maximum subarray problem which is solved by Kadane's algorithm
 */
public class RadioCommercials {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in), 1024 * 1024));
        int n = sc.nextInt();
        int price = sc.nextInt();

        int maxOverall = 0;
        int maxStart = -1;
        int maxEnd = -1;

        int current = -1;
        int start = -1;
        for (int i = 0; i < n; i++) {
            int profit = sc.nextInt() - price;
            if (current + profit > 0) {
                current += profit;
            } else {
                current = 0;
                start = i;
            }
            if (current > maxOverall) {
                maxOverall = current;
                maxStart = start;
                maxEnd = i;
            }
        }
        System.out.println(maxOverall);
    }
}

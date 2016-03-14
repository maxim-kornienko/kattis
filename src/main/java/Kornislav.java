import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/kornislav
 */
public class Kornislav {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int[] steps = new int[4];
        for (int i = 0; i < steps.length; i++) {
            steps[i] = sc.nextInt();
        }
        Arrays.sort(steps);
        int area = steps[0] * steps[2];
        System.out.println(area);
    }
}

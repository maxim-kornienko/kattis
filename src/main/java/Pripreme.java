import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/pripreme
 */
public class Pripreme {

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in), 1024 * 1024);
        Scanner sc = new Scanner(in);
        int elementsCount = sc.nextInt();
        long sum = 0;
        long max = Long.MIN_VALUE;
        for (int i = 0; i < elementsCount; i++) {
            int element = sc.nextInt();
            sum += element;
            if (max < element)
                max = element;
        }

        if (max > sum - max) {
            System.out.println(max * 2);
        } else {
            System.out.println(sum);
        }
    }
}

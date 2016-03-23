import java.util.Scanner;

/**
 * https://open.kattis.com/problems/sjecista
 */
public class Sjecista {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextInt();

        // for each 4 vertices there is one intersection of diagonals
        long result = n * (n - 1) * (n - 2) * (n - 3) / (1 * 2 * 3 * 4);
        System.out.println(result);
    }
}

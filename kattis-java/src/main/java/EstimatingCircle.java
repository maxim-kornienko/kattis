import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/estimatingtheareaofacircle
 */
public class EstimatingCircle {

    private static final double EPS = Math.pow(10, -5);

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));

        double r = sc.nextDouble();
        int m = sc.nextInt();
        int c = sc.nextInt();
        while (r != 0.0 && m != 0 && c != 0) {
            double trueArea = Math.PI * Math.pow(r, 2);
            double estimateArea = Math.pow(2 * r, 2) * c / m;
            System.out.printf("%f %f\n", trueArea, estimateArea);

            r = sc.nextDouble();
            m = sc.nextInt();
            c = sc.nextInt();
        }
    }
}

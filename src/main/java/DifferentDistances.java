import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/differentdistances
 */
public class DifferentDistances {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        String[] line = sc.nextLine().split(" ");
        while (line.length == 5) {
            double x1 = Double.parseDouble(line[0]);
            double y1 = Double.parseDouble(line[1]);
            double x2 = Double.parseDouble(line[2]);
            double y2 = Double.parseDouble(line[3]);
            double p = Double.parseDouble(line[4]);

            double norm = Math.pow(Math.pow(Math.abs(x1 - x2), p) + Math.pow(Math.abs(y1 - y2), p), 1.0 / p);
            System.out.println(norm);
            line = sc.nextLine().split(" ");
        }
    }
}

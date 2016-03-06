import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://open.kattis.com/problems/halfacookie
 */
public class HalfACookie {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in), 1024 * 1024);

        String line = in.readLine();
        while (line != null) {
            String[] l = line.split(" ");
            double r = Double.parseDouble(l[0]);
            double x = Double.parseDouble(l[1]);
            double y = Double.parseDouble(l[2]);
            calculateAreas(r, x, y);
            line = in.readLine();
        }
    }

    public static void calculateAreas(double r, double x, double y) {
        double h0 = Math.sqrt(Math.pow(x, 2 ) + Math.pow(y, 2)); // distance from the center to the point
        if (h0 >= r) {
            System.out.println("miss");
            return;
        }

        double h1 = r - h0; // height of the segment
        double a1 = Math.pow(r, 2) * Math.acos(1 - h1 / r) - (r - h1) * Math.sqrt(2 * r * h1 - Math.pow(h1, 2));
        double a0 = Math.PI * Math.pow(r, 2) - a1;
        System.out.printf("%f %f\n", Math.max(a1, a0), Math.min(a1, a0));
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://open.kattis.com/problems/areal
 */
public class ARealChallenge {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        double area = Double.parseDouble(in.readLine());
        double perimeter = Math.sqrt(area) * 4;
        System.out.println(perimeter);
    }
}

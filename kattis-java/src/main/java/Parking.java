import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://open.kattis.com/problems/parking2
 */
public class Parking {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int testCasesCount = Integer.parseInt(in.readLine());
        for (int t = 0; t < testCasesCount; t++) {
            System.out.println(nextTestCase(in));
        }
    }

    public static int nextTestCase(BufferedReader in) throws IOException {
        int shopsCount = Integer.parseInt(in.readLine());
        String[] shopsPositions = in.readLine().split(" ");
        int min = 99;
        int max = 0;
        for (int s = 0; s < shopsCount; s++) {
            int shopPosition = Integer.parseInt(shopsPositions[s]);
            if (shopPosition < min)
                min = shopPosition;
            if (max < shopPosition)
                max = shopPosition;
        }
        return (max - min) * 2;
    }
}

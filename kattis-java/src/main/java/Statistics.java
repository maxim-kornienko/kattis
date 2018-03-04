import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://open.kattis.com/problems/statistics
 */
public class Statistics {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();
        int caseId = 1;
        while (line != null) {
            processStatistics(caseId, line);
            line = in.readLine();
            caseId++;
        }
    }

    public static void processStatistics(int caseId, String line) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        String[] tokens = line.split(" ");
        for (int i = 1; i < tokens.length; i++) {
            int element = Integer.parseInt(tokens[i]);
            if (element < min)
                min = element;
            if (element > max)
                max = element;
        }
        System.out.printf("Case %d: %d %d %d\n", caseId, min, max, max - min);
    }
}

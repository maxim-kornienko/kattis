import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://open.kattis.com/problems/lineup
 */
public class LineThemUp {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(in.readLine());
        int prevOrder = 0;
        int curOrder = 0;
        String prev = in.readLine();
        for (int i = 1; i < size; i++) {
            String cur = in.readLine();
            curOrder = prev.compareTo(cur);
            if ((curOrder > 0 && prevOrder < 0) || (curOrder < 0 && prevOrder > 0)) {
                System.out.println("NEITHER");
                return;
            }
            prev = cur;
            prevOrder = curOrder;
        }
        if (curOrder < 0) {
            System.out.println("INCREASING");
        } else {
            System.out.println("DECREASING");
        }
    }
}

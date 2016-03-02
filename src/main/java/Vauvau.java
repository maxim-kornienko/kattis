import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://open.kattis.com/problems/vauvau
 */
public class Vauvau {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in), 8092);
        String[] dogsLine = in.readLine().split(" ");
        Dog d1 = new Dog(Integer.parseInt(dogsLine[0]), Integer.parseInt(dogsLine[1]));
        Dog d2 = new Dog(Integer.parseInt(dogsLine[2]), Integer.parseInt(dogsLine[3]));

        String[] visitorsLine = in.readLine().split(" ");
        for (String visitor : visitorsLine) {
            int v = Integer.parseInt(visitor);
            if (d1.isAggressive(v) && d2.isAggressive(v)) {
                System.out.println("both");
            } else if (d1.isAggressive(v) ^ d2.isAggressive(v)) {
                System.out.println("one");
            } else {
                System.out.println("none");
            }
        }
    }

    static class Dog {
        final int aggressive;
        final int calm;

        Dog(int aggressive, int calm) {
            this.aggressive = aggressive;
            this.calm = calm;
        }

        boolean isAggressive(int time) {
            return (time - 1) % (aggressive + calm) < aggressive;
        }
    }
}

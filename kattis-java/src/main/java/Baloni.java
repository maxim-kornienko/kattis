import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://open.kattis.com/problems/baloni
 */
public class Baloni {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] balloons = new int[n];
        for (int i = 0; i < n; i++) {
            balloons[i] = sc.nextInt();
        }

        int arrowsCount = 0;
        Map<Integer, AtomicInteger> arrows = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int height = balloons[i];
            AtomicInteger arrowBefore = arrows.get(height);
            if (arrowBefore != null && arrowBefore.get() > 0) {
                arrowBefore.decrementAndGet();
            } else {
                arrowsCount++;
            }

            AtomicInteger arrowAfter = arrows.computeIfAbsent(height - 1, it -> new AtomicInteger());
            arrowAfter.incrementAndGet();
        }
        System.out.println(arrowsCount);
    }
}

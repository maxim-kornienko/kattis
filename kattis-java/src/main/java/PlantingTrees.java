import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/plantingtrees
 */
public class PlantingTrees {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));

        int[] seedings = new int[sc.nextInt()];
        for (int i = 0; i < seedings.length; i++) {
            seedings[i] = sc.nextInt();
        }

        Arrays.sort(seedings);

        int maxDays = 0;
        for (int i = 1; i <= seedings.length; i++) {
            maxDays = Math.max(maxDays, i + seedings[seedings.length - i]);
        }
        System.out.println(maxDays + 1);
    }
}

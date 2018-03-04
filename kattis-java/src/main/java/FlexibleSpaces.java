import java.io.BufferedInputStream;
import java.util.BitSet;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/flexible
 */
public class FlexibleSpaces {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int width = sc.nextInt();
        
        int[] partitions = new int[sc.nextInt() + 2];
        partitions[0] = 0;
        for (int i = 1; i < partitions.length - 1; i++) {
            partitions[i] = sc.nextInt();
        }
        partitions[partitions.length - 1] = width;

        BitSet sizes = new BitSet(width);
        for (int i = 0; i < partitions.length - 1; i++) {
            for (int j = i + 1; j < partitions.length; j++) {
                sizes.set(partitions[j] - partitions[i]);
            }
        }

        for (int i = 0; i <= width; i++) {
            if (sizes.get(i)) {
                System.out.print(i);
                System.out.print(' ');
            }
        }
    }
}

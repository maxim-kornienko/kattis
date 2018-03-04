import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/permutedarithmeticsequence
 */
public class PermutedArithmeticSequence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));

        int testCasesCount = sc.nextInt();
        for (int t = 0; t < testCasesCount; t++) {
            int n = sc.nextInt();
            int[] sequence = new int[n];
            for (int i = 0; i < n; i++) {
                sequence[i] = sc.nextInt();
            }
            if (isArithmetic(sequence)) {
                System.out.println("arithmetic");
            } else if (isPermutedArithmeticWithoutSorting(sequence)) {
                System.out.println("permuted arithmetic");
            } else {
                System.out.println("non-arithmetic");
            }
        }
    }

    private static boolean isArithmetic(int[] sequence) {
        int diff = sequence[1] - sequence[0];
        for (int i = 2; i < sequence.length; i++) {
            if (sequence[i] - sequence[i - 1] != diff)
                return false;
        }
        return true;
    }

    private static boolean isPermutedArithmeticBruteForce(int[] sequence) {
        int[] copy = new int[sequence.length];
        System.arraycopy(sequence, 0, copy, 0, sequence.length);

        Arrays.sort(copy);
        return isArithmetic(copy);
    }

    private static boolean isPermutedArithmeticWithoutSorting(int[] sequence) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int s : sequence) {
            min = Math.min(min, s);
            max = Math.max(max, s);
        }

        int range = max - min;
        if (range % (sequence.length - 1) != 0)
            return false;

        int diff = range / (sequence.length - 1);

        BitSet flags = new BitSet(sequence.length); // we wouldn't need this if sequence did not contain duplicates

        for (int s : sequence) {
            int offset = s - min;
            if (offset % diff != 0)
                return false;
            flags.set(offset / diff);
        }

        for (int i = 0; i < sequence.length; i++) {
            if (!flags.get(i))
                return false;
        }

        return true;
    }
}

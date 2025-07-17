import java.util.BitSet;
import java.util.Scanner;

public class JollyJumpers {

    private static boolean isJollySequence(int[] sequence) {
        BitSet punchCard = new BitSet(sequence.length - 1);

        for (int i = 1; i < sequence.length; i++) {
            int diff = Math.abs(sequence[i - 1] - sequence[i]);
            if (diff > 0 && diff < punchCard.size() + 1) {
                punchCard.set(diff - 1);
            }
        }

        for (int i = 0; i < sequence.length - 1; i++) {
            if (!punchCard.get(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] sequence = new int[n];
            for (int i = 0; i < n; i++) {
                sequence[i] = sc.nextInt();
            }
            System.out.println(isJollySequence(sequence) ? "Jolly" : "Not jolly");
        }
    }
}

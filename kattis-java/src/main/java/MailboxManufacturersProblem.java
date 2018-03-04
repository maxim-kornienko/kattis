import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/mailbox
 */
public class MailboxManufacturersProblem {
    private boolean[][][] visited;
    /** Holds results of {@link #doSolve(int, int, int)}} calculation */
    private int[][][] cache;

    public MailboxManufacturersProblem(int crackersLimit, int mailboxes) {
        visited = new boolean[crackersLimit + 1][crackersLimit + 1][mailboxes + 1];
        cache = new int[crackersLimit + 1][crackersLimit + 1][mailboxes + 1];
    }

    /**
     * @param lo        the number of crackers that are known to be safe for mailbox
     * @param hi        hi + 1
     *                  the number of crackers that are known to destroy the mailbox
     * @param mailboxes number of mailboxes available
     * @return minimum number of fire crackers
     */
    public int solve(int lo, int hi, int mailboxes) {
        if (visited[lo][hi][mailboxes])
            return cache[lo][hi][mailboxes];
        cache[lo][hi][mailboxes] = doSolve(lo, hi, mailboxes);
        visited[lo][hi][mailboxes] = true;
        return cache[lo][hi][mailboxes];
    }

    private int doSolve(int lo, int hi, int mailboxes) {
        assert lo <= hi;
        assert mailboxes > 0;

        if (lo == hi)
            return  0;

        if (mailboxes == 1) {
            return (hi + lo + 1) * (hi - lo) / 2;
        } else {
            int min0 = Integer.MAX_VALUE;
            for (int p = lo + 1; p <= hi; p++) {
                int minP = p + Math.max(
                        solve(lo, p - 1, mailboxes - 1), // if cracks
                        solve(p, hi, mailboxes) // if resists
                );
                if (minP < min0)
                    min0 = minP;
            }
            return min0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCasesCount = sc.nextInt();
        for (int t = 0; t < testCasesCount; t++) {
            int mailboxes = sc.nextInt();
            int crackersLimit = sc.nextInt();
            MailboxManufacturersProblem problem = new MailboxManufacturersProblem(crackersLimit, mailboxes);
            System.out.println(problem.solve(0, crackersLimit, mailboxes));
        }
    }
}

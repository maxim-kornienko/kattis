import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/averageseasy
 */
public class ParadoxWithAverages {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int testCasesCount = Integer.parseInt(sc.nextLine());

        for (int t = 0; t < testCasesCount; t++) {
            int[] csStudents = new int[sc.nextInt()];
            int[] eStrudents = new int[sc.nextInt()];

            Arrays.setAll(csStudents, i -> sc.nextInt());
            Arrays.setAll(eStrudents, i -> sc.nextInt());

            double csAvg = avg(csStudents);
            double eAvg = avg(eStrudents);

            int trueFor = 0;
            for (int i = 0; i < csStudents.length; i++) {
                if (csStudents[i] < csAvg && csStudents[i] > eAvg) {
                    trueFor++;
                }
            }
            System.out.println(trueFor);
        }
    }

    private static double avg(int[] iqs) {
        int total = 0;
        for (int iq : iqs) {
            total += iq;
        }
        return ((double) total) / iqs.length;
    }
}

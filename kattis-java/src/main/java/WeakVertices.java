import java.io.BufferedInputStream;
import java.util.BitSet;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/weakvertices
 */
public class WeakVertices {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();

        while (n != -1) {
            int[][] matrix = new int[n][n];

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            findWeakVerticies(matrix);
            n = sc.nextInt();
        }
    }

    private static void findWeakVerticies(int[][] matrix) {
        BitSet strong = new BitSet(matrix.length);

        for (int v1 = 0; v1 < matrix.length; v1++) {
            for (int v2 = v1 + 1; v2 < matrix.length; v2++) {
                if (!areConnected(matrix, v1, v2))
                    continue;
                for (int v3 = v2 + 1; v3 < matrix.length; v3++) {
                    if (!areConnected(matrix, v1, v3))
                        continue;
                    if (!areConnected(matrix, v2, v3))
                        continue;
                    strong.set(v1);
                    strong.set(v2);
                    strong.set(v3);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (!strong.get(i))
                System.out.printf("%d ",+ i);
        }
        System.out.println();
    }

    private static boolean areConnected(int[][] matrix, int v1, int v2) {
        return matrix[v1][v2] == 1;
    }
}

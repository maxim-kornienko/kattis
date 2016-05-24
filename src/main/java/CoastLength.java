import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/coast
 */
public class CoastLength {

    private final static byte SEA = -1;
    private final static byte WATER = 0;
    private final static byte LAND = 1;

    private final byte[][] map;
    private final int n;
    private final int m;

    public CoastLength(int n, int m) {
        this.n = n;
        this.m = m;
        map = new byte[n][m];
    }

    public void set(int i, int j, byte value) {
        map[i][j] = value;
    }

    public void markSea(int i, int j) {
        if (i < 0 || i >= n)
            return;
        if (j < 0 || j >= m)
            return;

        if (map[i][j] != WATER)
            return;

        map[i][j] = SEA;

        markSea(i - 1, j); // north
        markSea(i + 1, j); // south
        markSea(i, j + 1); // east
        markSea(i, j - 1); // west
    }

    public long measureCoastLength() {
        long coastLength = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == LAND) {
                    // north
                    if (map[i - 1][j] == SEA)
                        coastLength++;
                    // south
                    if (map[i + 1][j] == SEA)
                        coastLength++;
                    // east
                    if (map[i][j + 1] == SEA)
                        coastLength++;
                    // west
                    if (map[i][j - 1] == SEA)
                        coastLength++;
                }
            }
        }
        return coastLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        String[] sizes = sc.nextLine().split(" ");
        int n = Integer.parseInt(sizes[0]);
        int m = Integer.parseInt(sizes[1]);

        // We will make 1 cell WATER padding around the map to keep if simple
        CoastLength cl = new CoastLength(n + 2, m + 2);

        for (int i = 0; i < n; i++) {
            String mapLine = sc.nextLine();
            for (int j = 0; j < m; j++) {
                if (mapLine.charAt(j) == '1') {
                    cl.set(i + 1, j + 1, LAND);
                }
            }
        }

        cl.markSea(0, 0);
        System.out.println(cl.measureCoastLength());
    }
}

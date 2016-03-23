import java.util.Scanner;

/**
 * https://open.kattis.com/problems/maptiles2
 */
public class IdentifyingMapTiles {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String quadKey = sc.nextLine();
        int zoomLevel = quadKey.length();
        long x = 0;
        long y = 0;
        int currentZoomLevel = zoomLevel;
        for (int i = 0; i < quadKey.length(); i++) {
            currentZoomLevel--;

            if (quadKey.charAt(i) == '0')
                continue;

            long step = 1L << currentZoomLevel;
            if (quadKey.charAt(i) == '1') {
                x += step;
            } else if (quadKey.charAt(i) == '2') {
                y += step;
            } else if (quadKey.charAt(i) == '3') {
                x += step;
                y += step;
            }
        }
        System.out.printf("%d %d %d", zoomLevel, x, y);
    }
}

import java.io.BufferedInputStream;
import java.util.*;

/**
 * https://open.kattis.com/problems/fire2
 */
public class Fire {

    private static int IMPPOSIBLE_TO_EXIT = -1;

    private static char ROOM = '.';
    private static char WALL = '#';
    private static char PLAYER = '@';
    private static char FIRE = '*';

    private final char[][] map;
    private final int startW;
    private final int startH;

    public Fire(char[][] map, int startH, int startW) {
        this.map = map;
        this.startH = startH;
        this.startW = startW;
    }

    public int getMinimumExitTime() {
        Queue<Long> movesQueue = new LinkedList<>();
        movesQueue.add(convert(startH, startW));

        Queue<Long> fireQueue = initFireQueue(new LinkedList<>());

        int time = 1;
        while (!movesQueue.isEmpty()) {
            int movesQueueSize = movesQueue.size();
            for (int m = 0; m < movesQueueSize; m++) {
                long playerCoordinates = movesQueue.remove();
                int playerH = getH(playerCoordinates);
                int playerW = getW(playerCoordinates);

                if (map[playerH][playerW] == FIRE)
                    continue;

                boolean reachedExit = false;
                reachedExit |= movePlayer(movesQueue, playerH - 1, playerW);
                reachedExit |= movePlayer(movesQueue, playerH + 1, playerW);
                reachedExit |= movePlayer(movesQueue, playerH, playerW - 1);
                reachedExit |= movePlayer(movesQueue, playerH, playerW + 1);
                if (reachedExit)
                    return time;
            }

            int fireQueueSize = fireQueue.size();
            for (int f = 0; f < fireQueueSize; f++) {
                long fireCoordinates = fireQueue.remove();
                int fireH = getH(fireCoordinates);
                int fireW = getW(fireCoordinates);

                assert map[fireH][fireW] == FIRE;

                spreadFire(fireQueue, fireH - 1, fireW);
                spreadFire(fireQueue, fireH + 1, fireW);
                spreadFire(fireQueue, fireH, fireW - 1);
                spreadFire(fireQueue, fireH, fireW + 1);
            }
            time++;
        }

        return IMPPOSIBLE_TO_EXIT;
    }

    private Queue<Long> initFireQueue(Queue<Long> fireQueue) {
        for (int h = 0; h < map.length; h++) {
            for (int w = 0; w < map[h].length; w++) {
                if (map[h][w] == FIRE) {
                    fireQueue.add(convert(h, w));
                }
            }
        }
        return fireQueue;
    }

    private void spreadFire(Queue<Long> fireQueue, int h, int w) {
        if (h < 0 || h >= map.length || w < 0 || w >= map[h].length)
            return;

        if (map[h][w] == ROOM || map[h][w] == PLAYER) {
            map[h][w] = FIRE;
            fireQueue.add(convert(h, w));
        }
    }

    /**
     * @return true if border was reached, false otherwise
     */
    private boolean movePlayer(Queue<Long> movesQueue, int h, int w) {
        if (h < 0 || h >= map.length || w < 0 || w >= map[h].length)
            return true;

        if (map[h][w] == ROOM) {
            map[h][w] = PLAYER;
            movesQueue.add(convert(h, w));
        }
        return false;
    }

    private static long convert(int h, int w) {
        return (long) h << 32 | w;
    }

    private static int getH(long coordinates) {
        return (int) (coordinates >> 32);
    }

    private static int getW(long coordinates) {
        return (int) coordinates;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int testCasesCount = Integer.parseInt(sc.nextLine());
        for (int t = 0; t < testCasesCount; t++) {
            StringTokenizer line = new StringTokenizer(sc.nextLine());
            int width = Integer.parseInt(line.nextToken());
            int height = Integer.parseInt(line.nextToken());
            Fire fire = readMap(sc, width, height);
            int minExitTime = fire.getMinimumExitTime();
            if (minExitTime == IMPPOSIBLE_TO_EXIT) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(minExitTime);
            }
        }
    }

    private static Fire readMap(Scanner sc, int width, int height) {
        char[][] map = new char[height][];
        int startW = -1;
        int startH = -1;
        for (int h = 0; h < height; h++) {
            String line = sc.nextLine();
            if (line.length() != width)
                throw new IllegalArgumentException();
            map[h] = line.toCharArray();
            for (int w = 0; w < map[h].length; w++) {
                if (map[h][w] == PLAYER) {
                    startW = w;
                    startH = h;
                }
            }
        }
        if (startH == -1 || startW == -1)
            throw new IllegalArgumentException();

        return new Fire(map, startH, startW);
    }
}

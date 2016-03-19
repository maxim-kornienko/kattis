import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/2048
 */
public class Game2048 {
    enum Move {
        LEFT(0, 4, 1),
        UP(0, 1, 4),
        RIGHT(15, -4, -1),
        DOWN(15, -1, -4);

        private int start;
        private int groupDelta;
        private int cellDelta;

        Move(int start, int groupDelta, int cellDelta) {
            this.start = start;
            this.cellDelta = cellDelta;
            this.groupDelta = groupDelta;
        }

        /**
         * Makes one iteration of the game
         */
        public void loop(int[] cells) {
            for (int g = 0; g < 4; g++) {
                // form normalized group
                int[] group = new int[4];
                for (int c = 0; c < 4; c++) {
                    group[c] = cells[getCell(g, c)];
                }
                // do transformation
                group = process(group);
                // propagate results back
                for (int c = 0; c < 4; c++) {
                    cells[getCell(g, c)] = group[c];
                }
            }
        }

        private int getCell(int g, int c) {
            int cell = start + g * groupDelta + c * cellDelta;
            if (cell >= 16) {
                cell %= 16;
            }
            if (cell < 0) {
                cell += 16;
            }
            return cell;
        }

        /**
         * Processes normalized line of cells.
         * Argument is a horizontal line of game board that should be shifted to the left.
         */
        public int[] process(int[] group) {
            return collide(compact(group));
        }

        public int[] compact(int[] group) {
            int[] result = new int[group.length];
            int cur = 0;
            for (int i = 0; i < group.length; i++) {
                if (group[i] == 0)
                    continue;
                result[cur++] = group[i];
            }
            return result;
        }

        public int[] collide(int[] group) {
            int[] result = new int[group.length];
            int cur = 0;
            int i = 0;
            while (i < group.length) {
                if (i + 1 < group.length && group[i] == group[i + 1]) {
                    result[cur] = group[i] * 2;
                    i += 2;
                } else {
                    result[cur] = group[i];
                    i++;
                }
                cur++;
            }
            return result;
        }

        public static Move parse(int code) {
            if (code == 0) {
                return LEFT;
            } else if (code == 1) {
                return UP;
            } else if (code == 2) {
                return RIGHT;
            } else {
                return DOWN;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));

        int[] cells = new int[16];
        for (int i = 0; i < cells.length; i++) {
            cells[i] = sc.nextInt();
        }
        Move move = Move.parse(sc.nextInt());
        move.loop(cells);

        for (int i = 0; i < cells.length; i++) {
            System.out.print(cells[i]);
            if (i % 4 == 3) {
                System.out.println();
            } else {
                System.out.print(" ");
            }
        }
    }
}

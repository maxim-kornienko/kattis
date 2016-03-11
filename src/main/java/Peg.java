import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://open.kattis.com/problems/peg
 */
public class Peg {

    enum Direction {
        UP {
            @Override
            int getDx() {
                return 0;
            }

            @Override
            int getDy() {
                return -1;
            }
        },
        DOWN {
            @Override
            int getDx() {
                return 0;
            }

            @Override
            int getDy() {
                return 1;
            }
        },
        LEFT {
            @Override
            int getDx() {
                return -1;
            }

            @Override
            int getDy() {
                return 0;
            }
        },
        RIGHT {
            @Override
            int getDx() {
                return 1;
            }

            @Override
            int getDy() {
                return 0;
            }
        };

        abstract int getDx();
        abstract int getDy();
    }

    private final String[] board;

    public Peg(String[] board) {
        this.board = board;
    }

    public long countMoves() {
        long moves = 0;
        for (int x = 2; x < board.length - 2; x++) {
            for (int y = 2; y < board[x].length() - 2; y++) {
                char cell = getCell(x, y);
                if (cell != '.')
                    continue;
                for (Direction d : Direction.values()) {
                    if (checkDirection(x, y, d))
                        moves++;
                }
            }
        }
        return moves;
    }

    public char getCell(int x, int y) {
        return board[x].charAt(y);
    }

    public boolean checkDirection(int x, int y, Direction direction) {
        char cellOne = getCell(x + direction.getDx(), y + direction.getDy());
        char cellTwo = getCell(x + 2 * direction.getDx(), y + 2 * direction.getDy());
        return cellOne == 'o' && cellTwo =='o';
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] board = new String[11];
        board[0] = "         ";
        board[1] = "         ";
        for (int i = 2; i < 9; i++) {
            board[i] = "  " + in.readLine() + "  ";
        }
        board[9] = "         ";
        board[10] = "         ";
        System.out.println(new Peg(board).countMoves());
    }
}

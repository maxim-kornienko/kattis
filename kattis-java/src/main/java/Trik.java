import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/trik
 */
public enum Trik {
    A {
        @Override
        void move(boolean[] cups) {
           swap(cups, 0, 1);
        }
    },
    B {
        @Override
        void move(boolean[] cups) {
            swap(cups, 2, 1);
        }
    },
    C {
        @Override
        void move(boolean[] cups) {
            swap(cups, 0, 2);
        }
    };

    abstract void move(boolean[] cups);

    void swap(boolean[] cups, int i, int j) {
        boolean temp = cups[i];
        cups[i] = cups[j];
        cups[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        String line = sc.nextLine();

        boolean[] cups = {true, false, false};
        for (char move : line.toCharArray()) {
            if (move == 'A') {
                A.move(cups);
            } else if (move == 'B') {
                B.move(cups);
            } else {
                C.move(cups);
            }
        }
        for (int i = 0; i < cups.length; i++) {
            if (cups[i])
                System.out.println(i + 1);
        }
    }
}

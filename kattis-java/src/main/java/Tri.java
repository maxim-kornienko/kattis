import java.util.Scanner;

/**
 * https://open.kattis.com/problems/tri
 */
public enum Tri {
    PLUS {
        @Override
        boolean mathces(int a1, int a2, int a3) {
            return a1 + a2 == a3;
        }

        @Override
        char getSymbol() {
            return '+';
        }
    },
    MINUS {
        @Override
        boolean mathces(int a1, int a2, int a3) {
            return a1 - a2 == a3;
        }

        @Override
        char getSymbol() {
            return '-';
        }
    },
    MULTIPLY {
        @Override
        boolean mathces(int a1, int a2, int a3) {
            return a1 * a2 == a3;
        }

        @Override
        char getSymbol() {
            return '*';
        }
    },
    DIVIDE {
        @Override
        boolean mathces(int a1, int a2, int a3) {
            return a1 % a2 == 0 && a1 / a2 == a3;
        }

        @Override
        char getSymbol() {
            return '/';
        }
    };

    abstract boolean mathces(int a1, int a2, int a3);

    abstract char getSymbol();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[3];
        a[0] = sc.nextInt();
        a[1] = sc.nextInt();
        a[2] = sc.nextInt();

        for (Tri t : values()) {
            if (t.mathces(a[0], a[1], a[2])) {
                System.out.printf("%d%s%d=%d",  a[0], t.getSymbol(), a[1], a[2]);
                return;
            }
            if (t.mathces(a[1], a[2], a[0])) {
                System.out.printf("%d=%d%s%d",  a[0], a[1], t.getSymbol(), a[2]);
                return;
            }
        }
    }
}

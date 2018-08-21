import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.ToDoubleBiFunction;

/**
 * https://open.kattis.com/problems/beehives
 */
public class Beehives {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new BufferedInputStream(System.in))) {
            while (true) {
                double sourDistance = sc.nextDouble();
                int n = sc.nextInt();

                if (sourDistance == 0.0 && n == 0)
                    break;

                List<Beehive> beehives = new ArrayList<>(n);
                for (int i = 0; i < n; i++) {
                    beehives.add(new Beehive(sc.nextDouble(), sc.nextDouble()));
                }

                int sour = getSourCount(sourDistance, beehives);
                int sweet = n - sour;

                System.out.printf("%d sour, %d sweet", sour, sweet);
                System.out.println();
            }
        }
    }

    private static int getSourCount(double sourDistance, List<Beehive> beehives) {
        beehives.sort(Comparator.comparing(Beehive::getX));

        ToDoubleBiFunction<Beehive, Beehive> distance = (a, b) -> Math.sqrt(
                Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2)
        );

        for (int i = 0; i < beehives.size(); i++) {
            Beehive a = beehives.get(i);
            int j = i + 1;
            while (j < beehives.size()) {
                Beehive b = beehives.get(j);
                if (b.getX() - a.getX() > sourDistance)
                    break;
                if (distance.applyAsDouble(a, b) < sourDistance) {
                    a.setSour(true);
                    b.setSour(true);
                }
                j++;
            }
        }

        return Math.toIntExact(
                beehives.stream()
                        .filter(Beehive::isSour)
                        .count()
        );
    }

    private static class Beehive {
        private final double x;
        private final double y;
        private boolean isSour;

        Beehive(double x, double y) {
            this.x = x;
            this.y = y;
        }

        double getX() {
            return x;
        }

        double getY() {
            return y;
        }

        boolean isSour() {
            return isSour;
        }

        void setSour(boolean sour) {
            isSour = sour;
        }
    }
}

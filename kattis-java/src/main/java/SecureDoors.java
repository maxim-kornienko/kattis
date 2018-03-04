import java.io.BufferedInputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://open.kattis.com/problems/securedoors
 */
public class SecureDoors {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));

        int n = Integer.parseInt(sc.nextLine());

        Set<String> insideBuilding = new HashSet<>(1000);
        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(" ");
            String command = line[0];
            String person = line[1];
            if ("entry".equals(command)) {
                boolean anomaly = !insideBuilding.add(person);
                if (anomaly) {
                    System.out.println(person + " entered (ANOMALY)");
                } else {
                    System.out.println(person + " entered");
                }
            } else if ("exit".equals(command)) {
                boolean anomaly = !insideBuilding.remove(line[1]);
                if (anomaly) {
                    System.out.println(person + " exited (ANOMALY)");
                } else {
                    System.out.println(person + " exited");
                }
            }
        }
    }
}

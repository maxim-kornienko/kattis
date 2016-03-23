import java.io.BufferedInputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://open.kattis.com/problems/modulo
 */
public class Modulo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));

        Set<Integer> modulos = new HashSet<>(1000);
        for (int i = 0; i < 10; i++) {
            modulos.add(sc.nextInt() % 42);
        }
        System.out.println(modulos.size());
    }
}

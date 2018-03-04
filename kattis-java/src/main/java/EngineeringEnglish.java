import java.io.BufferedInputStream;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

/**
 * https://open.kattis.com/problems/engineeringenglish
 */
public class EngineeringEnglish {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));

        Set<String> dictionary = new HashSet<>(20000);
        while (sc.hasNext()) {
            String word = sc.next();
            boolean unique = dictionary.add(word.toLowerCase(Locale.ENGLISH));
            if (unique) {
                System.out.print(word);
            } else {
                System.out.print('.');
            }
            System.out.print(' ');
        }
    }
}

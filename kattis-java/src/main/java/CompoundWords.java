import java.io.BufferedInputStream;
import java.util.*;

/**
 * https://open.kattis.com/problems/compoundwords
 */
public class CompoundWords {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        List<String> words = new ArrayList<>();
        while (sc.hasNext()) {
            words.add(sc.next());
        }

        Set<String> result = new TreeSet<>();
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.size(); j++) {
                if (i == j)
                    continue;
                result.add(words.get(i) + words.get(j));
            }
        }

        for (String r : result) {
            System.out.println(r);
        }
    }
}

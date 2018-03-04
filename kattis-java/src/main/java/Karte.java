import java.io.BufferedInputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://open.kattis.com/problems/karte
 */
public class Karte {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));

        String line = sc.nextLine();

        Set<String> cards = new HashSet<>(4 * 13);

        for (int i = 0; i < line.length(); i+=3 ) {
            String card = line.substring(i, i + 3);
            cards.add(card);
        }

        if (cards.size() != line.length() / 3) {
            System.out.println("GRESKA");
            return;
        }

        int p = 13;
        int k = 13;
        int h = 13;
        int t = 13;

        for (String card : cards) {
            char suit = card.charAt(0);

            if (suit == 'P') {
                p--;
            } else if (suit == 'K' ) {
                k--;
            } else if (suit == 'H') {
                h--;
            } else {
                t--;
            }
        }

        System.out.printf("%d %d %d %d", p, k, h, t);
    }
}

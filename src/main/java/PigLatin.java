import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * https://open.kattis.com/problems/piglatin
 */
public class PigLatin {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));

        while (sc.hasNext()) {
            String line = sc.nextLine();
            StringTokenizer tokenizer = new StringTokenizer(line, " ");
            while (tokenizer.hasMoreTokens()) {
                String word = tokenizer.nextToken();
                int firstVowelIndex = getFirstVowelIndex(word);

                if (firstVowelIndex == 0) {
                    System.out.print(word);
                    System.out.print("yay");
                } else if (firstVowelIndex == -1) {
                    System.out.print(word);
                    System.out.print("ay");
                } else {
                    System.out.print(word.substring(firstVowelIndex, word.length()));
                    System.out.print(word.substring(0, firstVowelIndex));
                    System.out.print("ay");
                }
                System.out.print(' ');
            }
            System.out.println();
        }
    }

    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y';
    }

    public static int getFirstVowelIndex(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (isVowel(word.charAt(i)))
                return i;
        }
        return -1;
    }
}

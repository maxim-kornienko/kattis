import java.io.IOException;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/apaxiaaans
 */
public class Apaxiaaaaaaaaaaaans {

    public static void main(String[] args) throws IOException {
        final String name;
        try (Scanner scanner = new Scanner(System.in)) {
            name = scanner.nextLine();
        }
        String compactName = squeeze(name);
        System.out.println(compactName);
    }

    public static String squeeze(String name) {
        if (name.isEmpty())
            return "";

        StringBuilder result = new StringBuilder();
        result.append(name.charAt(0));
        for (int i = 1; i < name.length(); i++) {
            if (name.charAt(i - 1) == name.charAt(i))
                continue;
            result.append(name.charAt(i));
        }

        return result.toString();
    }
}

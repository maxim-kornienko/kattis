import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * https://open.kattis.com/problems/everywhere
 */
public class IVeBeenEverywhereMan {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in), 8092);
        int testCasesCount = Integer.parseInt(in.readLine());

        for (int i = 0 ; i < testCasesCount; i++) {
            System.out.println(count(in));
        }
    }

    public static int count(BufferedReader in) throws IOException {
        int citiesCount = Integer.parseInt(in.readLine());
        Set<String> set = new HashSet<>(100);
        for (int c = 0; c < citiesCount; c++) {
            String cityName = in.readLine();
            set.add(cityName);
        }
        return set.size();
    }
}

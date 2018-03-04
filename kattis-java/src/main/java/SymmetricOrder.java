import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://open.kattis.com/problems/symmetricorder
 */
public class SymmetricOrder {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in), 1024 * 1024);

        int listIndex = 0;
        String line = in.readLine();
        while (line != null) {
            listIndex++;
            int listSize = Integer.parseInt(line);
            if (listSize == 0)
                break;
            String[] names = new String[listSize];
            for (int i = 0; i < listSize; i++) {
                String name = in.readLine();
                if (i % 2 == 0) {
                    names[i / 2] = name;
                } else {
                    names[listSize - 1 - i / 2] = name;
                }
            }

            System.out.println("SET " + listIndex);
            for (int i = 0; i < listSize; i++) {
                System.out.println(names[i]);
            }
            line = in.readLine();
        }
    }
}

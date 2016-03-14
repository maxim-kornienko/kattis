import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * https://open.kattis.com/problems/phonelist
 */
public class PhoneList {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int testCasesCount = Integer.parseInt(in.readLine());
        for (int i = 0; i < testCasesCount; i++) {
            int numberOfPhoneNumbers = Integer.parseInt(in.readLine());
            Set<Long> phoneNumbers = new HashSet<>(numberOfPhoneNumbers);
            Set<Long> prefixes = new HashSet<>(numberOfPhoneNumbers * 10);
            boolean duplicateFound = false;
            for (int j = 0; j < numberOfPhoneNumbers; j++) {
                String number = "1" + in.readLine();
                duplicateFound = duplicateFound || saveNumber(phoneNumbers, prefixes, Long.valueOf(number));
            }
            System.out.println(duplicateFound ? "NO" : "YES");
        }
    }

    public static boolean saveNumber(Set<Long> phoneNumbers, Set<Long> prefixes, Long number) {
        if (!phoneNumbers.add(number))
            return true;

        // check if number is prefix of someone else
        if (!prefixes.add(number))
            return true;

        // check if some number is prefix of this one
        Long prefix = number / 10;
        while (prefix > 0) {
            if (phoneNumbers.contains(prefix))
                return true;

            if (!prefixes.add(prefix))
                return false;

            prefix /= 10;
        }
        return false;
    }
}
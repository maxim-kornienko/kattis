import java.io.*;

public class Toilet {

    public static void main(String[] args) throws IOException {
        main(System.in, System.out);
    }

    public static void main(InputStream input, PrintStream output) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(input), 8092);
        String data = in.readLine();

        int userPreferencesPolicy = data.charAt(0) == data.charAt(1) ? 0 : 1; // should first user adjust on entering?
        int alwaysUpPolicy = (data.charAt(1) == 'U' ? 0 : 1) + userPreferencesPolicy;  // should first user adjust on leave?
        int alwaysDownPolicy = (data.charAt(1) == 'D' ? 0 : 1) + userPreferencesPolicy; // should first user adjust on leave?

        for (int i = 2; i < data.length(); i++) {
            if (data.charAt(i - 1) != data.charAt(i)) {
                userPreferencesPolicy++;
            }
            if (data.charAt(i) == 'U') {
                alwaysDownPolicy++; // on enter
                alwaysDownPolicy++; // on leave
            } else if (data.charAt(i) == 'D') {
                alwaysUpPolicy++; // on enter
                alwaysUpPolicy++; // on leave
            }
        }


        output.println(alwaysUpPolicy);
        output.println(alwaysDownPolicy);
        output.println(userPreferencesPolicy);
    }


}

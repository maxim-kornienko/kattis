import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * https://open.kattis.com/problems/savingdaylight
 */
public class SavingDaylight {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in), 1024 * 1024);

        Pattern pattern = Pattern.compile("^(?<date>\\w+ \\w+ \\w+) (?<sunriseH>\\d+)[\\:](?<sunriseM>\\d+) (?<sunsetH>\\d+)[\\:](?<sunsetM>\\d+)");

        String line = in.readLine();
        while (line != null) {
            Matcher m = pattern.matcher(line);
            if (!m.find())
                throw new IllegalArgumentException();
            String date  = m.group("date");
            int sunriseH = Integer.parseInt(m.group("sunriseH"));
            int sunriseM = Integer.parseInt(m.group("sunriseM"));
            int sunsetH = Integer.parseInt(m.group("sunsetH"));
            int sunsetM = Integer.parseInt(m.group("sunsetM"));
            int duration = (sunsetH - sunriseH) * 60 + sunsetM - sunriseM;

            System.out.printf("%s %d hours %d minutes" + System.lineSeparator(), date, duration / 60, duration % 60);
            line = in.readLine();
        }
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/eligibility
 */
public class Eligibility {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCasesCount = sc.nextInt();
        for (int t = 0; t < testCasesCount; t++) {
            String name = sc.next();
            int startedStudy = Integer.parseInt(sc.next().substring(0, 4));
            int birthday = Integer.parseInt(sc.next().substring(0, 4));
            int coursesCompleted = sc.nextInt();

            if (startedStudy >= 2010 || birthday >= 1991) {
                System.out.println(name + " eligible");
            } else if (coursesCompleted > 40) {
                System.out.println(name + " ineligible");
            } else {
                System.out.println(name + " coach petitions");
            }
        }
    }
}



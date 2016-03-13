import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/busyschedule
 */
public class BusySchedule {
    private static final int MINUTES_IN_A_DAY = 24 * 60;
    private static final String TIME_FORMAT = "%d:%02d %s";

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int appointments = Integer.parseInt(sc.nextLine());
        while (appointments > 0) {
            int[] calendar = new int[MINUTES_IN_A_DAY];
            for (int i = 0; i < appointments; i++) {
                calendar[convert(sc.nextLine())]++;
            }
            for (int i = 0; i < MINUTES_IN_A_DAY; i++) {
                if (calendar[i] > 0) {
                    String timeAmPm = convert(i);
                    for (int j = 0; j < calendar[i]; j++) {
                        System.out.println(timeAmPm);
                    }
                }
            }
            System.out.println();
            appointments = Integer.parseInt(sc.nextLine());
        }
    }

    public static int convert(String timeAmPm) {
        int pos = timeAmPm.indexOf(':');
        int hours = Integer.parseInt(timeAmPm.substring(0, pos));
        int minutes = Integer.parseInt(timeAmPm.substring(pos + 1, pos + 3));

        if (timeAmPm.endsWith("a.m.")) {
            return (hours % 12) * 60 + minutes;
        } else if (timeAmPm.endsWith("p.m.")) {
            return (12 + hours % 12) * 60 + minutes;
        }

        throw new IllegalArgumentException();
    }

    public static String convert(int time24) {
        int hours = time24 / 60;
        int minutes = time24 % 60;
        if (hours == 0) {
            return String.format(TIME_FORMAT, 12, minutes, "a.m.");
        } else if (hours < 12) {
            return String.format(TIME_FORMAT, hours, minutes, "a.m.");
        } else if (hours == 12) {
            return String.format(TIME_FORMAT, 12, minutes, "p.m.");
        } else {
            return String.format(TIME_FORMAT, hours % 12, minutes, "p.m.");
        }
    }
}

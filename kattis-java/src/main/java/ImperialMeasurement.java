import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/measurement
 */
public enum ImperialMeasurement {

    THOU("thou", "th", 1),
    INCH("inch", "in", THOU.thous * 1000),
    FOOT("foot", "ft", INCH.thous * 12),
    YARD("yard", "yd", FOOT.thous * 3),
    CHAIN("chain", "ch", YARD.thous * 22),
    FURLONG("furlong", "fur", CHAIN.thous * 10),
    MILE("mile", "mi", FURLONG.thous * 8),
    LEAGUE("league", "lea", MILE.thous * 3);

    private String fullName;
    private String acronym;
    private int thous;

    ImperialMeasurement(String fullName, String acronym, int thous) {
        this.fullName = fullName;
        this.acronym = acronym;
        this.thous = thous;
    }

    public static ImperialMeasurement find(String name) {
        for (ImperialMeasurement im : values()) {
            if (im.fullName.equals(name) || im.acronym.equals(name))
                return im;
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        String[] line = sc.nextLine().split(" ");
        double value = Double.parseDouble(line[0]);
        ImperialMeasurement source = find(line[1]);
        ImperialMeasurement target = find(line[3]);
        double result = value * source.thous / target.thous;
        System.out.println(result);
    }
}

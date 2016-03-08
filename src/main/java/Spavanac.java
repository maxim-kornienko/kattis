import java.util.Scanner;

/**
 * https://open.kattis.com/problems/spavanac
 */
public class Spavanac {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int hours = s.nextInt();
        int minutes = s.nextInt();

        int time = hours * 60 + minutes;
        time -= 45;
        if (time < 0)
            time += 24 * 60;
        System.out.printf("%d %d", time / 60, time % 60);
    }
}

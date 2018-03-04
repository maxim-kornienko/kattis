import java.io.BufferedInputStream;
import java.util.EnumSet;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/ptice
 */
public enum Ptice {
    Adrian('A', 'B', 'C'),
    Bruno('B', 'A', 'B', 'C'),
    Goran('C', 'C', 'A', 'A', 'B', 'B');

    char[] answers;

    Ptice(char... answers) {
        this.answers = answers;
    }

    public boolean check(int question, char expectedAnswer) {
        return answers[question % answers.length] == expectedAnswer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int questionsCount = Integer.parseInt(sc.nextLine());
        String expectedAnswers = sc.nextLine();

        int[] scores = new int[Ptice.values().length];
        for (int i = 0; i < expectedAnswers.length(); i++) {
            for (Ptice p : Ptice.values()) {
                if (p.check(i, expectedAnswers.charAt(i))) {
                    scores[p.ordinal()]++;
                }
            }
        }

        int maxScore = 0;
        EnumSet<Ptice> best = EnumSet.noneOf(Ptice.class);
        for (Ptice p : Ptice.values()) {
            if (scores[p.ordinal()] == maxScore) {
                best.add(p);
            } else if (scores[p.ordinal()] > maxScore) {
                maxScore = scores[p.ordinal()];
                best = EnumSet.of(p);
            }
        }

        System.out.println(maxScore);
        for (Ptice p : best) {
            System.out.println(p.name());
        }
    }
}
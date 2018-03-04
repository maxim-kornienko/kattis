import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * https://open.kattis.com/problems/musicalnotation
 */
public class MusicalNotation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));

        int n = Integer.parseInt(sc.nextLine());

        NoteLine[] noteLines = prepareNoteLines();

        StringTokenizer notes = new StringTokenizer(sc.nextLine(), " ");
        while (notes.hasMoreTokens()) {
            String note = notes.nextToken();
            char pitch = note.charAt(0);
            int duration = note.length() == 1 ? 1 : Integer.parseInt(note.substring(1));
            addNote(noteLines, pitch, duration);
        }

        for (NoteLine noteLine : noteLines) {
            System.out.println(noteLine);
        }

    }

    private static NoteLine[] prepareNoteLines() {
        char[] notes = {'G', 'F', 'E', 'D', 'C', 'B', 'A', 'g', 'f', 'e', 'd', 'c', 'b', 'a'};
        NoteLine[] noteLines = new NoteLine[notes.length];
        for (int i = 0; i < notes.length; i++) {
            noteLines[i] = new NoteLine(notes[i], (i % 2 == 0 || notes[i] == 'c') ? ' ' : '-');
        }
        return noteLines;
    }

    private static void addNote(NoteLine[] noteLines, char pitch, int duration) {
        for (NoteLine noteLine : noteLines) {
            if (noteLine.pitch == pitch) {
                noteLine.appendNote(duration);
            } else {
                noteLine.appendSilence(duration);
            }
        }
    }

    static class NoteLine {
        char pitch;
        char padding;

        StringBuilder builder;

        public NoteLine(char pitch, char padding) {
            this.pitch = pitch;
            this.padding = padding;
            builder = new StringBuilder(pitch + ": ");
        }

        void appendSilence(int duration) {
            for (int i = 0; i < duration; i++) {
                builder.append(padding);
            }
            builder.append(padding);
        }

        void appendNote(int duration) {
            for (int i = 0; i < duration; i++) {
                builder.append('*');
            }
            builder.append(padding);
        }

        @Override
        public String toString() {
            // trim trailing padding
            return builder.substring(0, builder.length() - 1);
        }
    }
}

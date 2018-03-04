import java.util.*;

/**
 * https://open.kattis.com/problems/musicalscales
 */
public class MusicalScales {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Set<Note> melody = EnumSet.noneOf(Note.class);
        for (int i = 0; i < n; i++) {
            melody.add(Note.findByCode(sc.next()));
        }

        List<Note> matched = new ArrayList<>();
        for (Note dominant : Note.values()) {
            if (new MajorScale(dominant).matches(melody))
                matched.add(dominant);
        }
        if (matched.isEmpty()) {
            System.out.println("none");
        } else {
            matched.forEach(m -> System.out.print(m.code + " "));
        }
    }

    enum Note {
        A("A"),
        A_sharp("A#"),
        B("B"),
        C("C"),
        C_sharp("C#"),
        D("D"),
        D_sharp("D#"),
        E("E"),
        F("F"),
        F_sharp("F#"),
        G("G"),
        G_sharp("G#");

        String code;

        Note(String code) {
            this.code = code;
        }

        static Note findByCode(String code) {
            for (Note note : values()) {
                if (Objects.equals(code, note.code))
                    return note;
            }
            throw new IllegalArgumentException();
        }
    }

    static class MajorScale {
        private static final int[] INTERVALS = {2, 2, 1, 2, 2, 2, 1};
        Note dominant;
        Set<Note> notes;

        MajorScale(Note dominant) {
            this.dominant = dominant;

            int i = dominant.ordinal();
            notes = EnumSet.of(dominant);
            for (int interval : INTERVALS) {
                i += interval;
                notes.add(Note.values()[i % Note.values().length]);
            }
            notes = Collections.unmodifiableSet(notes);
        }

        public boolean matches(Collection<Note> melody) {
            return notes.containsAll(melody);
        }
    }
}

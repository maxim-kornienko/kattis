import java.io.BufferedInputStream;
import java.util.*;

/**
 * https://open.kattis.com/problems/falsesecurity
 */
public class FalseSenseOfSecurity {

    enum Morse {
        A('A', ".-"),
        B('B', "-..."),
        C('C', "-.-."),
        D('D', "-.."),
        E('E', "."),
        F('F', "..-."),
        G('G', "--."),
        H('H', "...."),
        I('I', ".."),
        J('J', ".---"),
        K('K', "-.-"),
        L('L', ".-.."),
        M('M', "--"),
        N('N', "-."),
        O('O', "---"),
        P('P', ".--."),
        Q('Q', "--.-"),
        R('R', ".-."),
        S('S', "..."),
        T('T', "-"),
        U('U', "..-"),
        V('V', "...-"),
        W('W', ".--"),
        X('X', "-..-"),
        Y('Y', "-.--"),
        Z('Z', "--.."),
        UNDERSCORE('_', "..--"),
        COMMA(',', ".-.-"),
        PERIOD('.', "---."),
        QUESTION_MARK('?', "----");

        static final Map<Character, Morse> symbolIndex = createSymbolIndex();
        static final Map<String, Morse> codeIndex = createCodeIndex();

        char symbol;
        String code;

        Morse(char symbol, String code) {
            this.symbol = symbol;
            this.code = code;
        }

        public char getSymbol() {
            return symbol;
        }

        public String getCode() {
            return code;
        }

        public int getCodeLength() {
            return code.length();
        }

        static Morse getByCode(String code) {
            return codeIndex.get(code);
        }

        static Morse getBySymbol(char character) {
            return symbolIndex.get(character);
        }

        static Map<Character, Morse> createSymbolIndex() {
            Map<Character, Morse> result = new HashMap<>(values().length);
            for (Morse m : values()) {
                result.put(m.symbol, m);
            }
            return Collections.unmodifiableMap(result);
        }

        static Map<String, Morse> createCodeIndex() {
            Map<String, Morse> result = new HashMap<>(values().length);
            for (Morse m : values()) {
                result.put(m.code, m);
            }
            return Collections.unmodifiableMap(result);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));

        while (sc.hasNextLine()) {
            String message = sc.nextLine();
            System.out.println(ohaver(message));
        }
    }

    static String ohaver(String message) {
        int[] codeLengths = new int[message.length()];
        StringBuilder morseMessage = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            Morse m = Morse.getBySymbol(message.charAt(i));
            morseMessage.append(m.getCode());
            codeLengths[i] = m.getCodeLength();
        }

        StringBuilder result = new StringBuilder(message.length());
        int pos = 0;
        for (int i = codeLengths.length - 1; i >= 0; i--) {
            String code = morseMessage.substring(pos, pos + codeLengths[i]);
            Morse m = Morse.getByCode(code);
            result.append(m.getSymbol());
            pos += codeLengths[i];
        }
        return result.toString();
    }
}

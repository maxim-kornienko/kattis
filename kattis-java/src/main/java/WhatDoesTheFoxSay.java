import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

/**
 * https://open.kattis.com/problems/whatdoesthefoxsay
 */
public class WhatDoesTheFoxSay {

    public static void main(String[] args) throws IOException {
        main(System.in, System.out);
    }

    public static void main(InputStream input, PrintStream output) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(input));
        Integer testCasesCount = Integer.valueOf(in.readLine());
        for (int t = 0; t < testCasesCount; t++) {
            String record = in.readLine();
            Set<String> sounds = new HashSet<String>(100);
            String phrase = in.readLine();
            while (!("what does the fox say?").equals(phrase)) {
                sounds.add(phrase.substring(phrase.lastIndexOf(" ") + 1, phrase.length()));
                phrase = in.readLine();
            }
            output.println(whatDoesTheFoxSay(record, sounds));
        }
    }

    public static String whatDoesTheFoxSay(String record, Set<String> sounds) {
        StringBuilder result = new StringBuilder();
        StringTokenizer tokenizer = new StringTokenizer(record, " ");
        while (tokenizer.hasMoreTokens()) {
            String sound = tokenizer.nextToken();
            if (sounds.contains(sound))
                continue;
            result.append(sound);
            result.append(' ');
        }
        return result.length() == 0 ? "" : result.substring(0, result.length() - 1);
    }
}

import java.io.BufferedInputStream;
import java.util.*;
import java.util.stream.Collectors;

/**
 * https://open.kattis.com/problems/conversationlog
 */
public class ConversationLog {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int numberOfMessages = Integer.parseInt(sc.nextLine());

        List<String> messages = new ArrayList<>(numberOfMessages);
        for (int i = 0; i < numberOfMessages; i++)
            messages.add(sc.nextLine());

        Set<String> uniqueUsers = new HashSet<>();
        Map<String, Word> wordsMap = new HashMap<>();
        for (String message : messages) {
            String[] messageWords = message.split(" ");
            String user = messageWords[0];
            uniqueUsers.add(user);
            for (int i = 1; i < messageWords.length; i++) {
                Word word = wordsMap.get(messageWords[i]);
                if (word == null) {
                    word = new Word(messageWords[i]);
                    word.users.add(user);
                    word.count = 1;
                    wordsMap.put(messageWords[i], word);
                } else {
                    word.users.add(user);
                    word.count ++;
                }
            }
        }

        List<String> result = wordsMap.values().stream()
                .filter(w -> w.users.size() == uniqueUsers.size())
                .sorted(Comparator.comparing(Word::getCount).reversed())
                .map(Word::getValue)
                .collect(Collectors.toList());
        if (result.isEmpty()) {
            System.out.println("ALL CLEAR");
        } else {
            result.forEach(System.out::println);
        }
    }


    private static class Word {
        private final String value;
        private int count;
        private final Set<String> users = new HashSet<>();

        Word(String value) {
            this.value = value;
        }

        String getValue() {
            return value;
        }

        int getCount() {
            return count;
        }
    }
}

import java.io.BufferedInputStream;
import java.util.*;

/**
 * https://open.kattis.com/problems/notamused
 */
public class NotAmused {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));

        Park park = new Park();

        while (sc.hasNext()) {
            String line = sc.nextLine();
            if ("OPEN".equals(line)) {
                park.open();
            } else if ("CLOSE".equals(line)) {
                park.close();
                System.out.println();
            } else {
                StringTokenizer tokenizer = new StringTokenizer(line, " ");
                String event = tokenizer.nextToken();
                String visitorName = tokenizer.nextToken();
                int time = Integer.parseInt(tokenizer.nextToken());
                if ("ENTER".equals(event)) {
                    park.enter(visitorName, time);
                } else if (("EXIT".equals(event))) {
                    park.exit(visitorName, time);
                }
            }
        }
    }

    static class Park {
        private TreeMap<String, Visitor> visitors = new TreeMap<>();
        private int day = 0;

        public void open() {
            day++;
        }

        public void enter(String visitorName, int time) {
            Visitor v = visitors.get(visitorName);
            if (v == null) {
                v = new Visitor(visitorName);
                visitors.put(visitorName, v);
            }
            v.enter(time);
        }

        public void exit(String visitorName, int time) {
            Visitor v = visitors.get(visitorName);
            v.exit(time);
        }

        public void close() {
            System.out.println(String.format("Day %d", day));
            for (Map.Entry<String, Visitor> e : visitors.entrySet()) {
                System.out.println(String.format("%s $%.2f", e.getKey(), e.getValue().getCost()));
            }
            visitors.clear();
        }
    }

    static class Visitor {
        private String name;
        private double cost;
        private int enter;

        public Visitor(String name) {
            this.name = name;
        }

        public void enter(int enter) {
            this.enter = enter;
        }

        public void exit(int exit) {
            this.cost += (exit - enter) * 0.10;
        }

        double getCost() {
            return cost;
        }
    }
}

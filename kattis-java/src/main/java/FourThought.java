import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/4thought
 */
public class FourThought {


    enum Operator {
        PLUS("+", 1) {
            @Override
            int eval(int a, int b) {
                return a + b;
            }
        },
        MINUS("-", 1) {
            @Override
            int eval(int a, int b) {
                return a - b;
            }
        },
        MULTIPLY("*", 2) {
            @Override
            int eval(int a, int b) {
                return a * b;
            }
        },
        DIVIDE("/", 2) {
            @Override
            int eval(int a, int b) {
                return a / b;
            }
        };

        String symbol;
        int priority;

        Operator(String symbol, int priority) {
            this.symbol = symbol;
            this.priority = priority;
        }

        boolean isHigherOrEqual(Operator other) {
            return this.priority >= other.priority;
        }

        abstract int eval(int a, int b);

        static Operator parse(String s) {
            for (Operator o : values()) {
                if (o.symbol.equals(s))
                    return o;
            }
            return null;
        }
    }


    public static void main(String[] args) {
        Map<Integer, String> cache = initCache();
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int testCasesCount = sc.nextInt();
        for (int t = 0; t < testCasesCount; t++) {
            int n = sc.nextInt();
            String expression = cache.get(n);
            if (expression == null) {
                System.out.println("no solution");
            } else {
                System.out.println(expression + " = " + n);
            }
        }
    }

    static Map<Integer, String> initCache() {
        Map<Integer, String> cache = new HashMap<>(4 * 4 * 4);

        Operator[] ops = Operator.values();
        String[] infix = new String[4 + 3];
        infix[0] = "4";
        infix[2] = "4";
        infix[4] = "4";
        infix[6] = "4";
        for (int i = 0; i < ops.length; i++) {
            infix[1] = ops[i].symbol;
            for (int j = 0; j < ops.length; j++) {
                infix[3] = ops[j].symbol;
                for (int k = 0; k < ops.length; k++) {
                    infix[5] = ops[k].symbol;
                    Integer val = eval(toPostfix(infix));
                    if (!cache.containsKey(val)) {
                        cache.put(val, unsplit(infix));
                    }
                }
            }
        }
        return cache;
    }

    static String[] toPostfix(String[] infix) {
        String[] postfix = new String[infix.length];
        int p = 0;
        LinkedList<String> operatorsStack = new LinkedList<>();

        for (int i = 0; i < infix.length; i++) {
            Operator operator = Operator.parse(infix[i]);
            if (operator == null) {
                postfix[p++] = infix[i];
            } else {
                if (operatorsStack.isEmpty()) {
                    operatorsStack.addFirst(operator.symbol);
                } else {
                    while (Operator.parse(operatorsStack.getFirst()).isHigherOrEqual(operator)) {
                        postfix[p++] = operatorsStack.removeFirst();
                        if (operatorsStack.isEmpty())
                            break;
                    }
                    operatorsStack.addFirst(operator.symbol);
                }
            }
        }

        while (!operatorsStack.isEmpty()) {
            postfix[p++] = operatorsStack.removeFirst();
        }

        return postfix;
    }

    static int eval(String[] postfix) {
        LinkedList<Integer> operandsStack = new LinkedList<>();

        for (int i = 0; i < postfix.length; i++) {
            Operator operator = Operator.parse(postfix[i]);
            if (operator == null) {
                operandsStack.addFirst(Integer.valueOf(postfix[i]));
            } else {
                int b = operandsStack.removeFirst();
                int a = operandsStack.removeFirst();

                operandsStack.addFirst(operator.eval(a, b));
            }
        }
        return operandsStack.removeFirst();
    }

    static String unsplit(String[] str) {
        StringBuilder builder = new StringBuilder();
        for (String s : str) {
            builder.append(s);
            builder.append(' ');
        }
        return builder.substring(0, builder.length() - 1);
    }
}

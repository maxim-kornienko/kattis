import java.util.*;

/**
 * https://open.kattis.com/problems/busnumbers
 */
public class BusNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] list = new int[n];
        for (int i = 0; i < n; i++)
            list[i] = sc.nextInt();
        Arrays.sort(list);

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < list.length) {
            int range = 0;
            while (i + range + 1 < list.length
                    && list[i + range] + 1 == list[i + range + 1])
                range++;

            if (range == 0) {
                sb.append(list[i]);
            } else if (range == 1) {
                sb.append(list[i]);
                sb.append(" ");
                sb.append(list[i + 1]);
            } else {
                sb.append(list[i]);
                sb.append("-");
                sb.append(list[i + range]);
            }
            sb.append(" ");

            i += range + 1;
        }
        System.out.println(sb);
    }
}

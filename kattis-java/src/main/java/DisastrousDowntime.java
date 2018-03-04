import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/server
 */
public class DisastrousDowntime {

    public static final int REQUEST_DURATION = 1000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int requestsCount = sc.nextInt();
        int serverCapacity = sc.nextInt();

        int[] requests = new int[requestsCount];
        requests[0] = sc.nextInt();
        int maxLoad = 1;
        int curLoad = 1;
        int nextTimeout = 0;

        for (int i = 1; i < requestsCount; i++) {
            requests[i] = sc.nextInt();
            curLoad++;
            while ((requests[i] >= requests[nextTimeout] + REQUEST_DURATION)) {
                nextTimeout++;
                curLoad--;
            }
            maxLoad = Math.max(maxLoad, curLoad);
        }

        int servers = (int) Math.ceil((double)maxLoad / serverCapacity);
        System.out.println(servers);
    }
}

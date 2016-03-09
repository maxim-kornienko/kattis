import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/synchronizinglists
 */
public class SynchronizingLists {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = sc.nextInt();
        while (n != 0) {
            int[] listOne = new int[n];
            int[] listTwo = new int[n];
            for (int i = 0; i < n; i++) {
                listOne[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                listTwo[i] = sc.nextInt();
            }
            print(sync(listOne, listTwo));
            System.out.println();
            n = sc.nextInt();
        }
    }

    private static int[] sync(int[] master, int[] slave) {
        int[] sortedMaster = getSortedCopy(master);
        int[] sortedSlave = getSortedCopy(slave);

        Map<Integer, Integer> map = new HashMap<>(master.length);
        for (int i = 0; i < master.length; i++) {
            map.put(sortedMaster[i], sortedSlave[i]);
        }

        int[] result = new int[sortedMaster.length];
        for (int i = 0; i < sortedMaster.length; i++) {
            result[i] = map.get(master[i]);
        }

        return result;
    }

    private static int[] getSortedCopy(int[] array) {
        int[] copy = new int[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        Arrays.sort(copy);
        return copy;
    }

    private static void print(int[] array) {
        for (int a : array) {
            System.out.println(a);
        }
    }
}

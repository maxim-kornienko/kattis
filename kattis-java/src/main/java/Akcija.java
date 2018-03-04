import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/akcija
 */
public class Akcija {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));

        int n = sc.nextInt();
        int[] books = new int[n];

        for (int i = 0; i < books.length; i++) {
            books[i] = sc.nextInt();
        }

        Arrays.sort(books);
        long price = 0;
        for (int i = 0; i < books.length ; i ++) {
            if (i % 3 == books.length % 3)
                continue;
            price += books[i];
        }

        System.out.println(price);
    }
}

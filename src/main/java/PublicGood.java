import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * https://open.kattis.com/problems/pubs
 */
public class PublicGood {

    private static final int PUB = 1;
    private static final int UNDEFINED = 0;
    private static final int HOUSE = -1;

    private int[] constructionSites;

    public PublicGood(int n) {
        this.constructionSites = new int[n];
    }

    public void connect(int a, int b) {
        if (constructionSites[a] == UNDEFINED && constructionSites[b] == UNDEFINED) {
            constructionSites[a] = PUB;
            constructionSites[b] = HOUSE;
        } else if (constructionSites[a] == UNDEFINED && constructionSites[b] != UNDEFINED) {
            constructionSites[a] = -constructionSites[b];
        } else if (constructionSites[a] != UNDEFINED && constructionSites[b] == UNDEFINED) {
            constructionSites[b] = -constructionSites[a];
        }
    }

    public boolean isPossible() {
        for (int i = 0; i < constructionSites.length; i++) {
            if (constructionSites[i] == UNDEFINED)
                return false;
        }
        return true;
    }

    public void print() {
        if (isPossible()) {
            PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
            for (int cs : constructionSites)
                out.print(cs == PUB ? "pub " : "house ");
            out.flush();
        } else {
            System.out.println("Impossible");
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        int m = sc.nextInt();
        PublicGood pb = new PublicGood(n);
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            pb.connect(a - 1, b - 1);
        }
        pb.print();
    }
}

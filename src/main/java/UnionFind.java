import java.io.*;

/**
 * https://open.kattis.com/problems/unionfind
 */
public class UnionFind {

    /**
     * Stores parent of corresponding element
     */
    private int[] parents;
    /**
     * Stores  size of sub tree, where corresponding element is the root
     */
    private int[] treeSizes;

    public UnionFind(int elements) {
        parents = new int[elements];
        treeSizes = new int[elements];
        for (int i = 0; i < elements; i++) {
            parents[i] = i;
            treeSizes[i] = 1;
        }
    }

    /**
     * Merges groups which elements A and B belong to
     */
    public void union(int elementA, int elementB) {
        int rootA = find(elementA);
        int rootB = find(elementB);
        if (rootA == rootB)
            return;

        if (treeSizes[rootA] < treeSizes[rootB]) {
            subdue(rootA, rootB);
        } else {
            subdue(rootB, rootA);
        }
    }

    private void subdue(int slave, int master) {
        parents[slave] = master;
        treeSizes[master] += treeSizes[slave];
    }

    /**
     * Finds group of given element and shortens the path while searching.
     */
    public int findWithReindex(int element) {
        if (element == parents[element]) {
            return element;
        } else {
            int root = find(parents[element]);
            parents[element] = root;
            return root;
        }
    }

    /**
     * Finds group of the given element.
     */
    public int find(int element) {
        int root = element;
        while (root != parents[root]) {
            // traverse upward
            root = parents[root];
        }
        return root;
    }

    public boolean areConnected(int elementA, int elementB) {
        return find(elementA) == find(elementB);
    }

    static String YES = "yes" + System.lineSeparator();
    static String NO = "no" + System.lineSeparator();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in), 1024 * 1024);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        String line = in.readLine();
        int pos = line.indexOf(' ');
        int elements = Integer.parseInt(line.substring(0, pos));
        UnionFind uf = new UnionFind(elements);

        int operations = Integer.parseInt(line.substring(pos + 1, line.length()));

        for (int i = 0; i < operations; i++) {
            line = in.readLine();
            char operator = line.charAt(0);
            pos = line.lastIndexOf(' ');
            if (operator == '=') {
                uf.union(Integer.parseInt(line.substring(2, pos)), Integer.parseInt(line.substring(pos + 1, line.length())));
            } else {
                out.print(uf.areConnected(Integer.parseInt(line.substring(2, pos)), Integer.parseInt(line.substring(pos + 1, line.length()))) ? YES : NO);
            }
        }
        out.flush();
        out.close();
    }
}

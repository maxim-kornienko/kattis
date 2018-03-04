import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://open.kattis.com/problems/androids
 */
public class Androids {

    private final Planet[] planets;

    private final PriorityQueue<Connection> queue;
    private final BitSet connected;

    public Androids(Planet[] planets) {
        this.planets = planets;

        this.queue = new PriorityQueue<>();
        this.connected = new BitSet(planets.length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        Planet[] planets = new Planet[n];
        for (int i = 0; i < n; i++) {
            String[] line = in.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            int z = Integer.parseInt(line[2]);
            planets[i] = new Planet(i, x, y, z);
        }

        System.out.println(new Androids(planets).computeMinimumDistance());
    }

    private int computeMinimumDistance() {
        int totalDistance = 0;
        int i = 0;
        Planet start = planets[0];

        buildNetwork(planets);

        onConnect(start);
        i++;

        while (i < planets.length) {
            Connection connection = queue.remove();
            if (connected.get(connection.b.id))
                continue;
            onConnect(connection.b);
            i++;
            totalDistance += connection.distance;
        }
        return totalDistance;
    }

    private void onConnect(Planet a) {
        connected.set(a.id);
        for (Planet b : a.links) {
            if (connected.get(b.id))
                continue;
            queue.add(new Connection(a, b));
        }
    }

    private static void buildNetwork(Planet[] planets) {
        connectNeighbours(planets, (p1, p2) -> Integer.compare(p1.x, p2.x));
        connectNeighbours(planets, (p1, p2) -> Integer.compare(p1.y, p2.y));
        connectNeighbours(planets, (p1, p2) -> Integer.compare(p1.z, p2.z));
    }

    private static Planet[] connectNeighbours(Planet[] planets, Comparator<Planet> comparator) {
        Arrays.sort(planets, comparator);

        for (int i = 0; i < planets.length - 1; i++) {
            planets[i].links.add(planets[i + 1]);
            planets[i + 1].links.add(planets[i]);
        }
        return planets;
    }

    private static class Connection implements Comparable<Connection> {
        final Planet a;
        final Planet b;
        final int distance;

        Connection(Planet a, Planet b) {
            this.a = a;
            this.b = b;
            this.distance = Math.min(Math.min(Math.abs(a.x - b.x), Math.abs(a.y - b.y)), Math.abs(a.z - b.z));
        }

        @Override
        public int compareTo(Connection that) {
            return Integer.compare(this.distance, that.distance);
        }
    }

    private static class Planet {
        final int id;

        final int x;
        final int y;
        final int z;

        final List<Planet> links = new LinkedList<>();

        Planet(int id, int x, int y, int z) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://open.kattis.com/problems/speedlimit
 */
public class SpeedLimit {

    private int totalDistance;

    private int totalElapsedTime;

    public void addLog(int speed, int elapsedTime) {
        totalDistance += (elapsedTime - totalElapsedTime) * speed;
        totalElapsedTime = elapsedTime;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int logsCount = Integer.parseInt(in.readLine());
        while (logsCount != -1) {
            SpeedLimit result = new SpeedLimit();
            for (int i = 0; i < logsCount; i++) {
                String[] logLine = in.readLine().split(" ");
                result.addLog(Integer.parseInt(logLine[0]), Integer.parseInt(logLine[1]));
            }
            System.out.println(result.getTotalDistance() + " miles");
            logsCount = Integer.parseInt(in.readLine());
        }
    }
}

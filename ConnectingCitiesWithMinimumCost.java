import java.util.*;

public class ConnectingCitiesWithMinimumCost {
    /**
     * @param n:           the number of cities
     * @param connections: the connection info between cities
     * @return: nothing
     */

    public int minimumCost(int n, int[][] connections) {
        // write your code here
        Arrays.sort(connections, Comparator.comparing(o -> o[2]));
        int[] union = new int[n];
        for (int i = 0; i < union.length; i++) {
            union[i] = i;
        }
        int cost = 0;
        for (int[] arr : connections) {
            if (allCitiesConnected(union)) {
                return cost;
            }
            int city1 = arr[0] - 1;
            int city2 = arr[1] - 1;
            if (!isConnected(city1, city2, union)) {
                connect(city1, city2, union);
                cost += arr[2];
            }
        }
        if (allCitiesConnected(union)) {
            return cost;
        }
        return -1;
    }

    private boolean allCitiesConnected(int[] union) {
        for (int e : union) {
            if (e != union[0]) {
                return false;
            }
        }
        return true;
    }

    private void connect(int city1, int city2, int[] union) {
        int parent = union[city2];
        for (int i = 0; i < union.length; i++) {
            if (union[i] == parent) {
                union[i] = union[city1];
            }
        }
    }

    private boolean isConnected(int city1, int city2, int[] union) {
        return union[city1] == union[city2];
    }
}

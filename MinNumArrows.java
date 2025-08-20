import java.util.Arrays;
import java.util.Comparator;

public class MinNumArrows {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparing(o -> o[1]));
        int numArrows = 0;
        long prevEnd = Long.MIN_VALUE;
        for(int[] p : points) {
            if(p[0] > prevEnd) {
                numArrows++;
                prevEnd = p[1];
            }
        }
        return numArrows;
    }
}

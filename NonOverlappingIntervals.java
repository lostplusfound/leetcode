import java.util.*;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(o -> o[1]));
        int erased = 0;
        int prevFinish = 0;
        for(int[] i : intervals) {
            if(i[0] >= prevFinish) {
                prevFinish = i[1];
            } else {
                erased++;
            }
        }
        return erased;
    }
}

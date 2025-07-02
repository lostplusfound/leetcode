import java.util.*;

public class MaximumCoins {
    /**
     * @param heroes: An integer array
     * @param dungeons: An integer array
     * @param coins: An integer array
     * @return: Maximum number of coins that can be collect
     */
    public long[] maximumCoins(int[] heroes, int[] dungeons, int[] coins) {
        // write your code here
        long[] res = new long[heroes.length];
        int[][] pairs = new int[dungeons.length][2];
        for(int i = 0; i < dungeons.length; i++) {
            pairs[i] = new int[] {dungeons[i], i};
        }
        Arrays.sort(pairs, Comparator.comparing(o -> o[0]));
        long[] prefix = new long[dungeons.length];
        for(int i = 0; i < prefix.length; i++) {
            prefix[i] += coins[pairs[i][1]];
            if(i > 0) {
                prefix[i] += prefix[i - 1];
            }
        }
        for(int i = 0; i < heroes.length; i++) {
            int hero = heroes[i];
            int index = binarySearch(pairs, hero);
            res[i] = prefix[index];
        }
        return res;
    }

    public int binarySearch(int[][] pairs, int hero) {
        int L = 0;
        int H = pairs.length - 1;
        while(L <= H) {
            int mid = (L + H)/2;
            if(pairs[mid][0] == hero) {
                return mid;
            }
            else if(pairs[mid][0] > hero) {
                H = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        if(hero < pairs[L][0]) {
            return L;
        }
        return H;
    }
}
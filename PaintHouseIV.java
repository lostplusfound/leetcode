import java.util.*;

class PaintHouseIV {
    private Map<String, Long> cache = new HashMap<>();
    public long minCost(int n, int[][] cost) {
        long[] houses = new long[n];
        return dfs(0, houses,cost );
    }

    private long dfs(int d, long[] houses, int[][] cost) {
        if(d >= houses.length/2) {
            return 0;
        }
        int L = houses.length/2 - 1 - d;
        int R = houses.length/2 + d;
        int[] lCosts = cost[L];
        int[] rCosts = cost[R];
        long minCost = Long.MAX_VALUE;
        for(int lColor = 0; lColor < lCosts.length; lColor++) {
            for(int rColor = 0; rColor < rCosts.length; rColor++) {
                if(lColor == rColor) {
                    continue;
                }
                houses[L] = lColor;
                houses[R] = rColor;
                if(houses[L + 1] == lColor || houses[R - 1] == rColor) {
                    continue;
                }
                long currentCost = lCosts[lColor] + rCosts[rColor];
                String key = d + " " + houses[L] + " " + houses[R];
                if(cache.containsKey(key)) {
                    minCost = Math.min(minCost, currentCost + Math.min(minCost, cache.get(key)));
                    continue;
                }
                cache.put(key, dfs(d + 1, houses, cost));
                minCost = Math.min(minCost, currentCost + cache.get(key));
            }
        }
        return minCost;
    }
}